package com.testDemo.maintester;

import com.mainDemo.pojo.DataBase;
import com.mainDemo.pojo.ExcelTestable;
import com.mainDemo.questions.CheckForDirector;
import com.mainDemo.tasks.GetFurtherDetails;
import com.mainDemo.tasks.NavigateToWebPage;
import com.mainDemo.tasks.SearchForMovieName;
import com.mainDemo.utils.ResrcUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.TreeSet;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class TestIMDB_ShouldSeeDirectorNameTest {
    private TreeSet<String> sTestIDs;
    private final ExcelTestable dataBase = new DataBase(ResrcUtils.getFilePath(TestIMDB_ShouldSeeDirectorNameTest.class,"TestData.xlsx"));
    private final String worksheetName = "DataSet";
    private final int rowIndex = 0;
    private final String sHeaderTestIDCell = "Context";
    private final String sUserName = "userTaiger";

    @Managed(driver="chrome", uniqueSession = true)
    public WebDriver hisBrowser;

    Actor userTaiger = Actor.named(this.sUserName);

    @Before
    public void userCanBrowseTheWeb(){
        this.dataBase.set_Header_Index(this.worksheetName,this.rowIndex);
        this.dataBase.set_TestID_Index(this.worksheetName,this.sHeaderTestIDCell);
        this.sTestIDs = dataBase.getTestIDs(this.worksheetName);
        userTaiger.can(
                BrowseTheWeb.with(hisBrowser)
        );
    }

    @Test
    public void user_Should_See_The_Director_Name_Test(){
        this.dataBase.set_Header_Index(this.worksheetName,this.rowIndex);
        this.dataBase.set_TestID_Index(this.worksheetName,this.sHeaderTestIDCell);
        this.sTestIDs = dataBase.getTestIDs(this.worksheetName);
        this.sTestIDs.forEach(sTestID ->{
            String sSearchBox = this.dataBase.getValue(this.worksheetName,sTestID,"Search Box");
            String sDirectorName = this.dataBase.getValue(this.worksheetName,sTestID,"Director");

            givenThat(userTaiger).wasAbleTo(
                    NavigateToWebPage.toPageWithThisURL("https://www.imdb.com")
            );
            when(userTaiger).attemptsTo(
                    SearchForMovieName.with(sSearchBox),
                    GetFurtherDetails.ofDirector()
            );
            then(userTaiger).should(
                    seeThat("The name of the Director is ", CheckForDirector.getName(),equalTo(sDirectorName))
            );
        });
    }
}
