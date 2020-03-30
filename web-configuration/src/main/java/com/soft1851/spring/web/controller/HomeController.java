package com.soft1851.spring.web.controller;

import com.soft1851.spring.web.entity.Card;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @author xgp
 */
@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("message","Hello Spring MVC~~");
       Card[] cards = new Card[]{
               new Card(1, "Handsome man", "https://images.unsplash.com/photo-1496441277571-ff23e2363e05?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","Bad smile, immersed in the fragrance of love, intoxicated. Make a handsome boy in your mind"),
               new Card(2, "Pretty girl", "https://images.unsplash.com/photo-1584216338898-f34d78201414?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","Beautiful women, generally interpreted as young and beautiful women, are commonly used in Guangdong. Cantonese calls young and beautiful women beautiful women, while Mandarin calls them beautiful women."),
               new Card(3, "Sunglasses", "https://images.unsplash.com/photo-1555617117-08d2a80f6aa9?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60","Strong sunlight contains a lot of ultraviolet and infrared rays, which may damage the cornea, lens and even the fundus of the eye. Wearing a pair of sunglasses can block or absorb part of the light and reduce the irritation to the eyes. Because of the importance we attach to health."),
               new Card(4, "Perfume", "https://images.unsplash.com/photo-1566977776052-6e61e35bf9be?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","Perfume is an alcoholic solution of essence, plus a mixture of proper flavoring and so on. It is one of the most important cosmetics. It has a strong fragrance. Its main function is to spray it on the lapel, handkerchief, hairline and other parts to give off pleasant fragrance.")
       };
        List<Card> cardList = Arrays.asList(cards);
        model.addAttribute("cardList",cardList);
        return "templates/topic";    }
}
