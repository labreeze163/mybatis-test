package com.mybatis.type;

import com.mybatis.SqlSessionFactory.Blog;
import com.mybatis.SqlSessionFactory.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by hzzhaolong on 2016/2/16.
 */
public class TestSqlSessionFactory {

    /**
     *
     * 得到某天的结束时间
     *
     * @return
     * @since 2015年10月31日
     */
    public static long getEndOfDate(int days) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + days);
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = form.format(cal.getTime()) + " 23:59:59";
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            return 0L;
        }
        return date.getTime();
    }

    public static void main(String[] args) throws IOException {
        String resource = "sqlsession/oracle-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            Long endTime = getEndOfDate(-1);
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("endTime", new Date(endTime));
            params.put("pageSize", 40);
            params.put("lotteryType", 2);
            List<TurnPlateUserAward> awardList =  session.selectList("LotteryLog.getYesterdayUserAwards", params);
            System.out.println(awardList.size());
            for(TurnPlateUserAward award: awardList) {
//                System.out.println(award);
            }

//            TurnPlateUserAward userAward = awardList.get(0);
//            userAward.setId("100");
//            int insert = session.insert("LotteryLog.insertTbLotteryLog", userAward);
//            session.commit();
//            System.out.println("insert Result is " + insert);


            params.put("accountID", "hzztest1@126.com");
            params.put("beginNumber", 1);
            params.put("endNumber", 3);
            params.put("lotteryType", 2);
            awardList =  session.selectList("LotteryLog.getUserAwardsByUserName",params);
            System.out.println(awardList.size());

            for(TurnPlateUserAward award: awardList) {
                System.out.println(award.getId());
            }

        } finally {
            session.close();
        }


    }

}
