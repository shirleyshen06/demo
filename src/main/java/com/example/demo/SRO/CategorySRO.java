package com.example.demo.SRO;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class CategorySRO {
        private long id;
        private long subCategoryId;
        private String name;
        private String signSize;
        private int parmCheck;
        private LocalDateTime creatDate;
        private String updateBy;
        private LocalDateTime updatedDate;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getSubCategoryId() {
            return subCategoryId;
        }

        public void setSubCategoryId(long subCategoryId) {
            this.subCategoryId = subCategoryId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSignSize() {
            return signSize;
        }

        public void setSignSize(String signSize) {
            this.signSize = signSize;
        }

        public int getParmCheck() {
            return parmCheck;
        }

        public void setParmCheck(int parmCheck) {
            this.parmCheck = parmCheck;
        }

        public LocalDateTime getCreatDate() {
            return creatDate;
        }

        public void setCreatDate(LocalDateTime creatDate) {
            this.creatDate = creatDate;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public LocalDateTime getUpdatedDate() {
            return updatedDate;
        }

        public void setUpdatedDate(LocalDateTime updatedDate) {
            this.updatedDate = updatedDate;
        }
    }

