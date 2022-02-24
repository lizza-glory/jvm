package com.lizza.JVM;

import java.util.UUID;

/**
 *
 * 场景: 模拟主线程死循环, 不断创建新对象, GC 不断回收
 */
public class PsPoGC_1 {

    public static void main(String[] args){
        String s = "{\"source\":\"innerWebList\",\"uri\":\"/touch/api/domestic/wbdflightlist\",\"ip\":\"106.58.224.226\",\"loginStatus\":1,\"params\":{\"st\":\"1640006002354\",\"departureCity\":\"北京\",\"_v\":\"4\",\"ex_track\":\"\",\"__m__\":\"51e3afa199d8886672b908560b5e387f\",\"departureDate\":\"2022-01-31\",\"sort\":\"\",\"arrivalCity\":\"恩施\"},\"headers\":{\"host\":\"flight.qunar.com\",\"csht\":\"\",\"pre\":\"d9fd54c5-d04e56-5742d359-43a64631-fe91b707704c\",\""+ UUID.randomUUID()+"\":\"644ec994af8261b6b24d8807ad6c366aa45901f8\",\"w\":\"0\",\"user-agent\":\"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36\",\"content-type\":\"application/x-www-form-urlencoded\",\"accept\":\"text/javascript, text/html, application/xml, text/xml, */*\",\"x-requested-with\":\"XMLHttpRequest\",\"referer\":\"https://flight.qunar.com/site/oneway_list.htm?searchDepartureAirport=%e5%8c%97%e4%ba%ac&searchArrivalAirport=%e6%81%a9%e6%96%bd&searchDepartureTime=2022-01-31&searchArrivalTime=2022-01-31&nextNDays=0&startSearch=true&fromCode=BJS&toCode=ENH&from=qunarindex&from=fi_re_search&lowestPrice=true\",\"accept-encoding\":\"gzip, deflate, br\",\"accept-language\":\"zh-CN,zh;q=0.9\",\"req-id\":\"0000840030683bb83b902177\",\"x-real-ip\":\"106.58.224.226\",\"x-real-scheme\":\"https\",\"x-forwarded-for\":\"106.58.224.226\",\"x-forwarded-proto\":\"https\",\"qtraceid\":\"f_flight_touch_react_node_211220.211322.10.88.84.106.25381.2518517_1\",\"cookie\":\"fid=2f4cc89b-22fa-43b3-8496-4a27fc33381d;qunar-assist={%22version%22:%2220211215173359.925%22%2C%22show%22:false%2C%22audio%22:false%2C%22speed%22:%22middle%22%2C%22zomm%22:1%2C%22cursor%22:false%2C%22pointer%22:false%2C%22bigtext%22:false%2C%22overead%22:false%2C%22readscreen%22:false%2C%22theme%22:%22default%22};QN269=AEC697805D9A11ECA415FA163E7D47C7;QN621=1490067914133%3DDEFAULT%26fr%3Dqunarindex;QN668=51%2C56%2C54%2C50%2C50%2C50%2C55%2C59%2C58%2C57%2C59%2C50%2C55;QN601=0142f0b3a0b1849174ef2013580697b9;QN205=partner;QN667=B;QN48=000065802f103b82c27004f2;QunarGlobal=null_79a5803f_17dc3e83c12_-5d3b%7C1639971211425;_i=DFiEZz2Jr2vw7g6w-Ebn-e4t0JAw;QN277=partner;F235=1639929604359;QN300=organic;QN267=014294832757496a952;_vi=1P0rvq0zrIZAnvDZs3tyXmEk66Ihq9Jf1CpT_TAyLRWfGsYNtpMwFfU0gc3K2ATy-mHXEKhIp7oSSHzDLgx6de1xCC1wjPmyXOcyROMNIqE0AYIKQqV12NwATehnSHGmmdqxGdPag7vg3T_Xq2L49uicGp6gLvESY-AkC3xfHZ5W;csrfToken=Qpxfk6pNByiylhJtg6T5YqnT2EZDKhdt;QN1=00008b8030683b82c248db60;QN271=0aaa87fe-b081-4c20-904f-e4bafc8d49a5;Alina=be1edea8-898a21-38471c41-58aac451-5c8261b9d24f;QN99=2812;QN66=qunar\"},\"cookies\":{\"fid\":\"2f4cc89b-22fa-43b3-8496-4a27fc33381d\",\"qunar-assist\":\"{%22version%22:%2220211215173359.925%22%2C%22show%22:false%2C%22audio%22:false%2C%22speed%22:%22middle%22%2C%22zomm%22:1%2C%22cursor%22:false%2C%22pointer%22:false%2C%22bigtext%22:false%2C%22overead%22:false%2C%22readscreen%22:false%2C%22theme%22:%22default%22}\",\"QN269\":\"AEC697805D9A11ECA415FA163E7D47C7\",\"QN621\":\"1490067914133%3DDEFAULT%26fr%3Dqunarindex\",\"QN668\":\"51%2C56%2C54%2C50%2C50%2C50%2C55%2C59%2C58%2C57%2C59%2C50%2C55\",\"QN601\":\"0142f0b3a0b1849174ef2013580697b9\",\"QN205\":\"partner\",\"QN667\":\"B\",\"QN48\":\"000065802f103b82c27004f2\",\"QunarGlobal\":\"null_79a5803f_17dc3e83c12_-5d3b%7C1639971211425\",\"_i\":\"DFiEZz2Jr2vw7g6w-Ebn-e4t0JAw\",\"QN277\":\"partner\",\"F235\":\"1639929604359\",\"QN300\":\"organic\",\"QN267\":\"014294832757496a952\",\"_vi\":\"1P0rvq0zrIZAnvDZs3tyXmEk66Ihq9Jf1CpT_TAyLRWfGsYNtpMwFfU0gc3K2ATy-mHXEKhIp7oSSHzDLgx6de1xCC1wjPmyXOcyROMNIqE0AYIKQqV12NwATehnSHGmmdqxGdPag7vg3T_Xq2L49uicGp6gLvESY-AkC3xfHZ5W\",\"csrfToken\":\"Qpxfk6pNByiylhJtg6T5YqnT2EZDKhdt\",\"QN1\":\"00008b8030683b82c248db60\",\"QN271\":\"0aaa87fe-b081-4c20-904f-e4bafc8d49a5\",\"Alina\":\"be1edea8-898a21-38471c41-58aac451-5c8261b9d24f\",\"QN99\":\"2812\",\"QN66\":\"qunar\"},\"extInfo\":{\"fecheck\":\"true\"},\"clientSource\":\"WWW\",\"preToken\":\"d9fd54c5-d04e56-5742d359-43a64631-fe91b707704c\",\"alinaToken\":\"be1edea8-898a-471c-aac4-5c8261b9d24f\",\"fpCode\":\"\",\"riskLevel\":\"CRITICAL\",\"timeStamp\":1640006002400,\"vid\":0,\"ucode\":\"000065802f103b82c27004f2\",\"bver\":0.0}";
        System.out.println(s);
    }
}
