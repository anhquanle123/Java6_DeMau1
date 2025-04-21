package com.example.DeMau1.dto;

import java.time.LocalDate;

public interface NhanVienCustom {

    Integer getId();

    String getMaNhanVien();

    String getHoTen();

    Boolean getGioiTinh();

    LocalDate getNgaySinh();

    String getMaChucVu();

    String getTenChucVu();
}
