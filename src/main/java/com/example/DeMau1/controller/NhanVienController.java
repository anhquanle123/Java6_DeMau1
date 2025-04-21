package com.example.DeMau1.controller;

import com.example.DeMau1.dto.NhanVienCustom;
import com.example.DeMau1.dto.NhanVienRequest;
import com.example.DeMau1.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nhan-vien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public ResponseEntity<?> getAllNhanVien() {
        return ResponseEntity.ok(nhanVienService.getAllNhanVien());
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllNhanVien(@RequestParam(defaultValue = "0", name = "page") Integer page) {
        return ResponseEntity.ok(nhanVienService.getAllNhanVien(page));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid NhanVienRequest request, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.ok(nhanVienService.add(request));
        }
    }

    @GetMapping("/detail")
    public ResponseEntity<?> getDetail(@RequestParam("maNhanVien") String maNhanVien) {
        return nhanVienService.getDetailMa(maNhanVien)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/danh-sach-loc")
    public ResponseEntity<?> getNangCao() {
        List<NhanVienCustom> list = nhanVienService.getNangCao();
        return ResponseEntity.ok(list);
    }
}
