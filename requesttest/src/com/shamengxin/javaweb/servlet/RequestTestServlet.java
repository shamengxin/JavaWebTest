package com.shamengxin.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.DoubleToIntFunction;


/*
username=zhangsan&userpwd=123&interest=s&interest=d
Map<String,String[]>
key				value
---------------------------
"username"		{"zhangsan"}
"userpwd"		{"123"}
"interest"		{"s", "d"}

�ܽ�һ�£�request�ӿ����ĸ��ǳ���Ҫ�ķ�����
    Map<String,String[]> parameterMap = request.getParameterMap();
	Enumeration<String> names = request.getParameterNames();
	String[] values = request.getParameterValues("name");
	String value = request.getParameter("name");
*/
public class RequestTestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ����ӿڱ��:HttpServletRequest�ӿڡ�
        // ��ȡǰ���ύ������
        // ǰ�˻��ύʲô�����أ�
        // username=zhangsan&userpwd=123&interest=s&interest=d
        // ���ϵ����ݻᱻСè���װ��request�����С�

        // ��ȡ����Map����
        Map<String, String[]> parameterMap = request.getParameterMap();
        //����Map����
        Set<String> keys = parameterMap.keySet();
        Iterator<String> it= keys.iterator();
        while(it.hasNext()){
            String key = it.next();
            //System.out.println(key);
            //ͨ��key��ȡvalue
            String[] values = parameterMap.get(key);
            /*
                username=[Ljava.lang.String;@7881e80f
                userpwd=[Ljava.lang.String;@7646196f
                interest=[Ljava.lang.String;@7279837f
             */
            //System.out.println(key+"="+values);

            //����һά����
            System.out.print(key+"=");
            for(String value:values){
                System.out.print(value+",");
            }
            System.out.println();
        }

        //ֱ��ͨ��getParameterNames()�������������ֱ�ӻ�����Map���ϵ�����key
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            System.out.println(name);
        }

        //ֱ��ͨ��name��ȡvalue���һά����
        String[] usernames = request.getParameterValues("username");
        String[] userpwds = request.getParameterValues("userpwd");
        String[] interests = request.getParameterValues("interest");

        //����һά����
        for (String username:usernames){
            System.out.println(username);
        }

        for (String userpwd:userpwds){
            System.out.println(userpwd);
        }

        for (String interest:interests){
            System.out.println(interest);
        }

        //ͨ��name��ȡvalue���һά����ĵ�һ��Ԫ��
        //�������ʹ����࣬��Ϊ���һά������һ��ֻ��һ��Ԫ�ء�
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");
        //String interest = request.getParameter("interest");

        //��Ȼ��checkbox�����÷���gerParameterValues("interest")
        String[] interests1=request.getParameterValues("interest");


        System.out.println(username);
        System.out.println(userpwd);
        //System.out.println(interest);

        for (String interest:interests1){
            System.out.println(interest);
        }


    }
}
