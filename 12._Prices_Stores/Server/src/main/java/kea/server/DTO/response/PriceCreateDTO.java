package kea.server.DTO.response;

import kea.server.models.Price;

public class PriceCreateDTO {

    public Price price;
    public boolean failed;
    public String errorMessage;

    public PriceCreateDTO(Price price){
        this.price = price;
    }

    public PriceCreateDTO(String errorMessage){
        System.out.println(errorMessage);
        this.errorMessage = errorMessage;
        this.failed = true;
    }

}
