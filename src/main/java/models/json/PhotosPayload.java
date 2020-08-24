package models.json;

import java.util.ArrayList;
import java.util.List;

public class PhotosPayload {

    private List<String> photos = new ArrayList<>();

    public PhotosPayload(){

    }

    public PhotosPayload( List<String> photos){
        this.photos = photos;
    }



    public List<String> getPhotos() {
        return this.photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }



    
}