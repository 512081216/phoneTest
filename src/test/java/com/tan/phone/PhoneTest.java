package com.tan.phone;

import org.junit.Test;

public class PhoneTest {

    /**
     * 转换测试
     **/
    @Test
    public void convertTest2() {
        int [] arr1 = { 2, 3 };
        int [] arr2 = { 1, 9 };
        int [] arr3 = { 2, 3, 9 };
        int [] arr4 = { 98 };
        Phone phone = new Phone();
        System.out.println("arr1 result = " + phone.convert(arr1));
        System.out.println("arr2 result = " + phone.convert(arr2));
        System.out.println("arr3 result = " + phone.convert(arr3));
        System.out.println("arr4 result = " + phone.convert(arr4));
    }

}
