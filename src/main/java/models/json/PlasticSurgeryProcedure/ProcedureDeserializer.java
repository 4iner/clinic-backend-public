package models.json.PlasticSurgeryProcedure;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import models.enums.PlasticSurgeryProcedure;

public class ProcedureDeserializer extends StdDeserializer<PlasticSurgeryProcedure> {
 
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected ProcedureDeserializer(Class<?> vc) {
        super(vc);
    }

    protected ProcedureDeserializer(){
        super(PlasticSurgeryProcedure.class);
    }

    @Override
    public PlasticSurgeryProcedure deserialize(JsonParser jsonParser, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String procedure = node.asText();
        
        for (PlasticSurgeryProcedure p : PlasticSurgeryProcedure.values()) {
           
            if (p.getName().equals(procedure)) {
                return p;
            }
        }
 
        return null;
    }
}