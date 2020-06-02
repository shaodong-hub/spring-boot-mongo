package com.github.mongo.construct;/**
 * @author shao
 * @date 2020/6/2 11:52 上午
 * @version 1.0
 */

import com.github.mongo.pojo.orm.WebUvDO;
import com.github.mongo.repository.IWebViewReportRepository;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.RandomStringUtils;
import org.jetbrains.annotations.NotNull;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author 石少东
 * @date 2020-06-02 11:52
 */

@Component
public class InitUvData {

    private boolean init = true;
    private int hostnameNumber = 100;
    private int ips = 3000;

    @Resource
    private IWebViewReportRepository reportRepository;

    @PostConstruct
    public void init() {
        List<String> list = Lists.newArrayList();
        for (int i = 0; i < hostnameNumber; i++) {
            list.add(RandomStringUtils.randomAlphabetic(10));
        }
        if (init) {
            for (int i = 0; i < 3000; i++) {
                DateTime dateTime = new DateTime();
                list.forEach(one -> {
                            WebUvDO uv = WebUvDO.builder()
                                    .date(dateTime.plusMinutes(1).toDate())
                                    .hostname(one)
                                    .ips(getIps())
                                    .build();
                            reportRepository.save(uv);
                        }
                );
                System.out.println("初始化：" + i);
            }
        }
    }

    @NotNull
    private Set<String> getIps() {
        Set<String> set = Sets.newHashSet();
        for (int i = 0; i < ips; i++) {
            set.add(getRandomIp());
        }
        return set;
    }


    @NotNull
    public static String getRandomIp() {
        // ip范围
        int[][] range = {
                // 36.56.0.0-36.63.255.255
                {607649792, 608174079},
                // 61.232.0.0-61.237.255.255
                {1038614528, 1039007743},
                // 106.80.0.0-106.95.255.255
                {1783627776, 1784676351},
                // 121.76.0.0-121.77.255.255
                {2035023872, 2035154943},
                // 123.232.0.0-123.235.255.255
                {2078801920, 2079064063},
                // 139.196.0.0-139.215.255.255
                {-1950089216, -1948778497},
                // 171.8.0.0-171.15.255.255
                {-1425539072, -1425014785},
                // 182.80.0.0-182.92.255.255
                {-1236271104, -1235419137},
                // 210.25.0.0-210.47.255.255
                {-770113536, -768606209},
                // 222.16.0.0-222.95.255.255
                {-569376768, -564133889},
        };

        Random random = new Random();
        int index = random.nextInt(10);
        return num2ip(range[index][0] + new Random().nextInt(range[index][1] - range[index][0]));
    }


    private static String num2ip(int ip) {
        int[] b = new int[4];
        String ipStr = "";
        b[0] = ((ip >> 24) & 0xff);
        b[1] = ((ip >> 16) & 0xff);
        b[2] = ((ip >> 8) & 0xff);
        b[3] = (ip & 0xff);
        ipStr = b[0] + "." + b[1] + "." + b[2] + "." + b[3];
        return ipStr;
    }
}
