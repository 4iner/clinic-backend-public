package models.json.PlasticSurgeryProcedure;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import models.enums.PlasticSurgeryProcedure;

public class ProcedureSerializer extends StdSerializer<PlasticSurgeryProcedure> {

    /**
	 *
	 */
	private static final long serialVersionUID = 8741028881444941440L;



	public ProcedureSerializer(){
        super(PlasticSurgeryProcedure.class);
    }





    @Override
    public void serialize(PlasticSurgeryProcedure procedure, JsonGenerator generator, SerializerProvider provider)
            throws IOException {
        generator.writeString(procedure.getName());

    }


    
}