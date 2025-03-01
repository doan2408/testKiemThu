package com.example.demo;

public class SumArray {
    Integer tinhTongMang(int[] mang) {
        int sum = 0;
        if (mang == null) {
            throw new IllegalArgumentException("mang khong duoc null");
        }
        for (int i = 0; i < mang.length; i++) {
            sum += mang[i];
        }
        return sum;
    }


    //    cho số nguyên 1-50, tính tổng các số chẵn, bỏ qua những số chia hết cho 8
    public Integer tinhTong2() {
        int sum = 0;
        for (int i = 1; i <= 50; i++) {
            if (i % 2 == 0 && i % 8 != 0) {
                sum += i;
            }
        }
        return sum;
    }

    public void lietKe() {
        for (int i = 0; i < 101; i++) {
            if (i % 5 != 0) {
                System.out.println(i);
            }
        }
    }


//    tính tổng mảng các số nguyên, bỏ qua số lớn hơn 100

    public Integer tongMangSoNguyenBoQua100(int[] mang) {
        int sum = 0;
        for (int i = 0; i < mang.length; i++) {
            if(mang[i] <=100) {
                sum += mang[i];
            }
        }
        return sum;
    }


}
