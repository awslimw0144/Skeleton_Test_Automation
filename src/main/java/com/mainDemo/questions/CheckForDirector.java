package com.mainDemo.questions;

import com.mainDemo.pages.PageOfIMDB;
import net.serenitybdd.screenplay.Question;

public class CheckForDirector {
    public static Question<String> getName(){
        return actor -> PageOfIMDB.NAME_DIRECTOR.resolveFor(actor).getText();
    }
}
