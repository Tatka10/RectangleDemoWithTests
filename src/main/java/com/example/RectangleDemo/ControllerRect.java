package com.example.RectangleDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerRect {
    @GetMapping("/get_result")
    public String getResultFunc(String a, String b, Model model) throws GeometryException {
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        List<Rectangle> rectangles = new ArrayList<>();
        try {
            Rectangle rect = new Rectangle(x, y);

            double recPerimetr = rect.perimeter();
            double recArea = rect.area();
            model.addAttribute("recPerimetr", rect.perimeter());
            model.addAttribute("recArea", rect.area());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("errorMes", "Некорректные данные: " + e.getMessage());

        }


        return "result";
    }

    public void saveRectangles(Rectangle rect) {




    }
}
