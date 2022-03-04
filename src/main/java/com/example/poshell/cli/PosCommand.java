package com.example.poshell.cli;

import com.example.poshell.biz.PosService;
import com.example.poshell.model.Item;
import com.example.poshell.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class PosCommand {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @ShellMethod(value = "List Products", key = "l")
    public String products() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Product product : posService.products()) {
            stringBuilder.append("\t").append(++i).append("\t").append(product).append("\n");
        }
        return stringBuilder.toString();
    }

    @ShellMethod(value = "New Cart", key = "n")
    public String newCart() {
        return posService.newCart() + " OK";
    }

    @ShellMethod(value = "Add a Product to Cart", key = "a")
    public String addToCart(String productId, int amount) {
        if (posService.add(productId, amount)) {
            return posService.getCart().toString();
        }
        return "ERROR";
    }

    @ShellMethod(value = "Print all products in the Cart", key = "p")
    public String printCart(){
        return posService.getCart().toString();
    }

    @ShellMethod(value = "empty Cart", key = "e")
    public String emptyCart(){
        return posService.newCart() + " The Cart is empty now";
    }

    @ShellMethod(value = "modify Cart", key = "m")
    public String modifyCart(String productId, int amount){
        Item modifyTarget = posService.getCart().getItem(productId);
        if(modifyTarget == null)
            return "ERROR";
        else
            modifyTarget.setAmount(amount);
        return posService.getCart().toString();
    }
}
