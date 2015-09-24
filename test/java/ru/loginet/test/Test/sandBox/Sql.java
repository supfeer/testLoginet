package ru.loginet.test.Test.sandBox;

import org.testng.annotations.Test;
import ru.loginet.test.ojects.tools.SqlTool;

/**
 * Created by supfe_000 on 23.09.2015.
 */
public class Sql {


    @Test
    public void test() {
/*
        SqlTool.deleteRequest("РСВ00004801");
*/
        String[] names = {"РСВ00003842+РСВ00003851", "РСВ00003862+РСВ00003863", "РСВ00003823",
                "РСВ00003823 -отм", "141603", "РСВ00003830+РСВ00003831+РСВ00003852",
                "РСВ00003864", "РСВ00003723", "РСВ00003845"};
        SqlTool.deleteRequests(names);
    }
}
