package com.Jdai.bigdata.hadoop.mr.project.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class LogParserTest {
    LogParser logParser;
    @Before
    public void setup(){
        logParser = new LogParser();
    }
    @After
    public void teardown(){
        logParser = null;
    }
    @Test
    public void processTime(){
        String time = "2013-07-21 16:19:45";
        String hour = time.substring(11,13);
        System.out.println(hour);
    }
    @Test
    public void test01(){
        Map<String, String> map = logParser.parse("20962780901\u0001http://www.yihaodian.com/1/?tracker_u=10999948752&mz_ca=1006833&mz_sp=3yeZH0&mz_sb=1&type=2\u0001\u0001\u00013\u0001XRYNJGP51GPUVDMDB51BSU5KKAW3B4E4JQKB\u0001\u0001\u0001\u0001\u0001U8BC9ZEV7U8QJJWW92ACE3M3BV5SQCCN\u000110999948752\u0001\\N\u0001118.73.11.239\u0001\u0001msessionid:VNSAJ48DZ47Z53FH8X9X1NCUUFJ2JDXM,unionKey:10999948752\u0001\u00012013-07-21 14:00:57\u0001\\N\u0001\u00011\u0001\u0001\\N\u0001null\u0001392\u0001\u0001\u0001\u0001\u0001Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; GTB7.2; SV1; .NET4.0C)\u0001Win32\u0001\u0001\u0001\u0001\u0001\u0001山西省\u000132\u0001\u00012013-07-21 14:00:57\u0001临汾市\u0001\u000148\u0001\u0001\u0001\u0001\u0001\\N\u0001\\N\u0001\\N\u0001\\N\u00012013-07-21");
//        Map<String, String> map = logParser.parse("20970890580\u0001http://m.yihaodian.com/mw/register?provinceId=2&tempToken=bda25bd7-5b8d-47a5-9ea9-4fd57079a149&username=dm1017%40hotmail.com&password=ldmxzdmm&repassword=ldmxzdmm&verifycode=&changeverify=true\u0001http://m.yihaodian.com/mw/doregister?provinceId=2&tempToken=da2b950d-8023-4a45-870e-94a34cf6fbb9&username=dm1017%40hotmail.com&password=ldmxzdmm&repassword=ldmxzdmm&verifycode=lgqn&changeverify=\u0001\u00013\u000123NEFA14X62771N4XVBT28BBTED9V7TNHYMS\u0001\u0001\u0001\u0001\u0001Z6HEWPHDXGKWQGCEEH87DXZE19KX87A6\u000110107232037\u0001\\N\u0001118.186.140.69\u0001\u0001msessionid:AEM86BVQ9T27WAMNHBWJRKGHJF3GYR1R,unionKey:10107232037\u0001\u00012013-07-21 16:19:45\u0001\\N\u0001http://hao.uc.cn/index?lwy_ch=mynav&uc_param_str=frpfbivelabtbmntnieisidnpvsscpli\u000148\u0001\u0001\\N\u0001null\u0001-20\u0001\u0001\u0001\u0001\u00015.0 (Linux; U; Android 4.1.2; zh-CN; GT-N7100 Build/JZO54K) AppleWebKit/534.31 (KHTML\u0001Linux\u0001\u0001\u0001\u0001\u0001\u0001北京市\u00012\u0001\u0001\u0001北京市\u0001\u0001\u0001\u0001\u0001\u0001\u0001\\N\u0001\\N\u0001\\N\u0001\\N\u00012013-07-21");
//        Map<String, String> map = logParser.parse("0953394400\u0001http://m.yihaodian.com/mw/getcounty/128?fromid=2&provinceId_temp2=1&goodReceiverId=-1&provinceId_temp=1&cityId_temp=128&countyid=53&address1=&receiveName=&receiverMobile=&receiverPhone=\u0001http://m.yihaodian.com/mw/address/2\u0001\u00013\u0001C43RBRDX9S7R8K1NXJGN66FKJUHXD4BTH42F\u0001\u0001\u0001\u0001\u000113K8GAAPCKJZ7KNASP2S4Q5QS53JNTSE\u0001\\N\u0001\\N\u0001112.64.189.219\u0001\u0001msessionid:59WA86W9TQJ5XHMEBKQXSK9VZ1T7987Y,unionKey:null\u0001\u00012013-07-21 11:25:53\u0001\\N\u0001http://m.yihaodian.com/mw/doregister?provinceId=1&tempToken=a96e8824-0676-42b9-a99e-7c50a7d4cc49&username=zxsjn%40hotmail.com&password=921129&repassword=921129&verifycode=qvy5&changeverify=\u00019\u0001\u0001\\N\u0001null\u0001-10\u0001\u0001\u0001\u0001\u00011.0 Android/2.3.5 Release/9.15.2011 Browser/AppleWebKit533.1 Profile/MIDP-2.1 Configuration/CLDC-1.1\u0001Linux armv7l\u0001\u0001\u0001\u0001\u0001\u0001上海市\u00011\u0001\u0001\u0001上海市\u0001\u0001\u0001\u0001\u0001\u0001\u0001\\N\u0001\\N\u0001\\N\u0001\\N\u00012013-07-21");
//            Map<String, String> map  = logParser.parse("20946835322\u0001http://www.yihaodian.com/1/?tracker_u=2225501&type=3\u0001http://www.baidu.com/s?wd=1%E5%8F%B7%E5%BA%97&rsv_bp=0&ch=&tn=baidu&bar=&rsv_spt=3&ie=utf-8&rsv_sug3=5&rsv_sug=0&rsv_sug1=4&rsv_sug4=313&inputT=4235\u00011号店\u00011\u0001SKAPHD3JZYH9EE9ACB1NGA9VDQHNJMX1NY9T\u0001\u0001\u0001\u0001\u0001PPG4SWG71358HGRJGQHQQBXY9GF96CVU\u00012225501\u0001\\N\u0001124.79.172.232\u0001\u0001msessionid:YR9H5YU7RZ8Y94EBJNZ2P5W8DT37Q9JH,unionKey:2225501\u0001\u00012013-07-21 09:30:01\u0001\\N\u0001http://www.baidu.com/s?wd=1%E5%8F%B7%E5%BA%97&rsv_bp=0&ch=&tn=baidu&bar=&rsv_spt=3&ie=utf-8&rsv_sug3=5&rsv_sug=0&rsv_sug1=4&rsv_sug4=313&inputT=4235\u00011\u0001\u0001\\N\u0001null\u0001-10\u0001\u0001\u0001\u0001\u0001Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; MATP; Media Center PC 6.0; .NET4.0C; InfoPath.2; .NET4.0E)\u0001Win32\u0001\u0001\u0001\u0001\u0001\u0001上海市\u00011\u0001\u00012013-07-21 09:30:01\u0001上海市\u0001\u000166\u0001\u0001\u0001\u0001\u0001\\N\u0001\\N\u0001\\N\u0001\\N\u00012013-07-21\n");
//            for(Map.Entry<String,String> entry:map.entrySet()){
//                System.out.println(entry.getKey()+entry.getValue());
//            }
//        System.out.println("=============================================");
        System.out.println(map.get("url"));
        System.out.println(map.get("usernameStr"));
        System.out.println(map.get("username"));
        System.out.println(map.get("hour"));
        }
    @Test
    public void testLogParserV2(){
        Map<String, String> map = logParser.parse2("182.136.73.208\thttp://fashion.1mall.com/12/\t3DD3ENVMKM3B11KRH9RZGQ8M8XZ7WAM5\t2013-07-21 20:37:52\t中国\t四川省\t绵阳市\t-\n");
        System.out.println(map.get("hour"));
    }
    }

