package com.example.DeMau1.repository;

import com.example.DeMau1.dto.NhanVienCustom;
import com.example.DeMau1.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NhanVienRepo extends JpaRepository<NhanVien, Integer> {
    @Query(value = "SELECT nv.id, nv.ma_nhan_vien, nv.ho_ten, \n" +
            "nv.gioi_tinh, nv.ngay_sinh, cv.ma_chuc_vu, cv.ten_chuc_vu\n" +
            "FROM nhan_vien nv JOIN chuc_vu cv ON nv.id_chuc_vu = cv.id", nativeQuery = true)
    List<NhanVienCustom> getAllNhanVien();

    @Query(value = "SELECT nv.id, nv.ma_nhan_vien, nv.ho_ten, \n" +
            "nv.gioi_tinh, nv.ngay_sinh, cv.ma_chuc_vu, cv.ten_chuc_vu\n" +
            "FROM nhan_vien nv JOIN chuc_vu cv ON nv.id_chuc_vu = cv.id\n" +
            "WHERE nv.ma_nhan_vien = :maNhanVien", nativeQuery = true)
    Optional<NhanVienCustom> getNhanVienByMa(@Param("maNhanVien") String maNhanVien);

    @Query(value = "SELECT nv.id, nv.ma_nhan_vien, nv.ho_ten, \n" +
            "nv.gioi_tinh, nv.ngay_sinh, cv.ma_chuc_vu, cv.ten_chuc_vu\n" +
            "FROM nhan_vien nv JOIN chuc_vu cv ON nv.id_chuc_vu = cv.id\n" +
            "WHERE LOWER(nv.ho_ten) LIKE %:keyword%\n" +
            "AND DATEDIFF(YEAR, nv.ngay_sinh, GETDATE()) >= 18", nativeQuery = true)
    List<NhanVienCustom> getNangCao(@Param("keyword") String keyword);
}
