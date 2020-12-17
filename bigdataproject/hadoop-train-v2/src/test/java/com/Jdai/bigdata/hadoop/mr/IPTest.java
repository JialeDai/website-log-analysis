package com.Jdai.bigdata.hadoop.mr;

import com.Jdai.bigdata.hadoop.mr.project.utils.IPParser;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class IPTest {
    @Test
    public void testIP(){
        IPParser.RegionInfo regionInfo = IPParser.getInstance().analyseIp("10.0.21.112");
        System.out.println(regionInfo.getCountry());
        System.out.println(regionInfo.getProvince());
        System.out.println(regionInfo.getCity());
    }
    @Test
    public void testRegularExpression(){
        String dealId = "";
        String reg = "(?<=username=).*?(?=&)";
        Pattern p= Pattern.compile(reg);
        Matcher m=p.matcher("http://m.yihaodian.com/mw/doregister?provinceId=1&tempToken=a96e8824-0676-42b9-a99e-7c50a7d4cc49&username=zxsjn%40hotmail.com&password=921129&repassword=921129&verifycode=qvy5&changeverify=");
        m.find();
        dealId = m.group();
        System.out.println(dealId);
    }
}
