package com.example.RectangleDemo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//нужны тесты

@Service
public class RectangleService {
    List<Rectangle> rectangleList= new ArrayList<>();
    public void add (Rectangle rect){
        rectangleList.add(rect);
    }

    public List<Rectangle> getRectangleList() {
        return rectangleList;
    }
}
