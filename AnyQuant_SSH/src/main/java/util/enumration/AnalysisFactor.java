package util.enumration;

/**
 * 评估因子
 * @author Qiang
 * @date 16/5/19
 */
public enum AnalysisFactor {

    PE("市盈率"),
    PB("市净率"),
    VOL5("五日换手率"),
    VOL10("十日换手率"),
    VOL60("六十日换手率"),
    VOL120("120日换手率"),
    MA5("5日均线"),
    MA20("20日均线"),
    MA60("60日均线"),
    MA120("120日均线"),
    PS("市销率"),
    PSY("心理线指标"),
    PCF("市现率"),
    REC("分析师推荐评级"),
    DAREC("分析师推荐评级变化");
    private String chinese;

    AnalysisFactor(String chinese){
        this.chinese = chinese;
    }



    public String getChinese(){
        return chinese;
    }
}
