//package Adapters;
//
//public class ProductItem {
//    private String name, description,available,color,size;
//
//    public ProductItem(){}
//    public ProductItem(String name, String description, String available, String color, String size){
//        this.name = name;
//        this.description = description;
//        this.available = available;
//        this.color = color;
//        this.size = size;
//    }
//
//    public ProductItem(String name, String description, String units, String burrowTime) {
//    }
//
//    //set & get
//    public String getName () { return this.name;}
//    public void setName (String name) { this.name = name;}
//    public String getDescription() {return this.description;}
//    public void setDescription(String description) {this.description = description;}
//    public String getAvailable() {return this.available;}
//    public void setAvailable(String available) {this.available = available;}
//    public String getColor() {return this.color;}
//    public void setColor(String color) {this.color = color;}
//    public String getSize() {return this.size;}
//    public void setSize(String size) {this.size = size;}
//}
//}
package Adapters;

import android.net.Uri;

public class ProductItem {
    private String name, description, unitsInStock, burrowTime;

    public ProductItem(){}
    public ProductItem(String name, String description, String unitsInStock, String burrowTime){
        this.name = name;
        this.description = description;
        this.unitsInStock = unitsInStock;
        this.burrowTime = burrowTime;
    }
    //set & get
    public String getName () { return this.name;}
    public void setName (String name) { this.name = name;}
    public String getDescription() {return this.description;}
    public void setDescription(String description) {this.description = description;}
    public String getUnitsInStock() {return this.unitsInStock;}
    public void setUnitsInStock(String unitsInStock) {this.unitsInStock = unitsInStock;}
    public String getBurrowTime() {return this.burrowTime;}
    public void setBurrowTime(String burrowTime) {this.burrowTime = burrowTime;}
}

