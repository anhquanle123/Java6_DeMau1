package com.example.DeMau1.dto;

import com.example.DeMau1.entity.ChucVu;
import com.example.DeMau1.entity.NhanVien;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class NhanVienRequest {

    @NotBlank(message = "Mã nhân viên không được để trống!")
    private String maNhanVien;

    @NotBlank(message = "Tên nhân viên không được để trống!")
    private String hoTen;

    private String gioiTinh;

    private LocalDate ngaySinh;

    private Integer idChucVu;

    public NhanVien dto (NhanVien nhanVien) {
        nhanVien.setMaNhanVien(this.getMaNhanVien());
        nhanVien.setHoTen(this.getHoTen());
        nhanVien.setGioiTinh(Boolean.valueOf(this.getGioiTinh()));
        nhanVien.setNgaySinh(this.getNgaySinh());
        nhanVien.setChucVu(ChucVu.builder().idChucVu(this.getIdChucVu()).build());
        return nhanVien;
    }
}
