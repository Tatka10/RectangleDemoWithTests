package com.example.RectangleDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerRect {
    //вариант сделать список  - прямо полем контроллера
    //List<Rectangle> historyList = new ArrayList<>();
    //вариант современный, по-спринговски, сделать бин и связать через @service с бином контроллера
    @Autowired
    RectangleService rectangleService;

    @GetMapping("/get_result")
    public String getResultFunc(String a, String b, Model model) throws GeometryException {
        try {
            int x = Integer.parseInt(a);
            int y = Integer.parseInt(b);
            Rectangle rect = new Rectangle(x, y);
            double recPerimetr = rect.perimeter();
            double recArea = rect.area();
            model.addAttribute("recPerimetr", rect.perimeter());
            model.addAttribute("recArea", rect.area());
            //historyList.add(rect);
            rectangleService.add(rect);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("errorMes", "Некорректные данные: " + e.getMessage());

        }


        return "result";
    }

    @GetMapping("/history")
    public String showHistory(Model model) {
        //model.addAttribute("message", historyList.toString());
        model.addAttribute("message", rectangleService.getRectangleList().toString());


        return "history";
    }


}

