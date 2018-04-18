package jums;

/**
 * 画面系の処理や表示を簡略化するためのヘルパークラスです。定数なども保存されます
 *
 * @author hayashi-s
 */
public class JumsHelper {

    //トップへのリンクを定数として設定
    private final String homeURL = "index.jsp";

    public static JumsHelper getInstance() {
        return new JumsHelper();
    }

    //トップへのリンクを返却
    public String home() {
        return "<a href=\"" + homeURL + "\">トップへ戻る</a>";
    }

    public String backform(String name, String birthday, String type, String tell, String comment) {

        String nameform = "名前:" + name + "<br>";
        String birthdayform = "生年月日:" + birthday + "<br>";
        String typeform = "種別:" + type + "<br>";
        String tellform = "電話番号:" + tell + "<br>";
        String Cform = "自己紹介:" + comment + "<br>";

        String form = nameform + birthdayform + typeform + tellform + Cform;
        return form;
        
    }
}
