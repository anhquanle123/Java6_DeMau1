package com.example.DeMau1.service;

import com.example.DeMau1.dto.NhanVienCustom;
import com.example.DeMau1.dto.NhanVienRequest;
import com.example.DeMau1.entity.NhanVien;
import com.example.DeMau1.repository.NhanVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepo nhanVienRepo;

    public List<NhanVienCustom> getAllNhanVien() {
            return nhanVienRepo.getAllNhanVien();
    }

    public Page<NhanVien> getAllNhanVien(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return nhanVienRepo.findAll(pageable);
    }

    public NhanVien add(NhanVienRequest request) {
        NhanVien nv = request.dto(new NhanVien());
        return nhanVienRepo.save(nv);
    }

    public Optional<NhanVienCustom> getDetailMa(String maNhanVien) {
        return nhanVienRepo.getNhanVienByMa(maNhanVien);
    }

    public List<NhanVienCustom> getNangCao() {
        return nhanVienRepo.getNangCao("a");
    }
}
