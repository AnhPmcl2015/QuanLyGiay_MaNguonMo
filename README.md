# QuanLyGiay_MaNguonMo
# Change properties: file.location, username, password
  - file.location: nơi lưu trữ ảnh
# Admin
  - thêm 1 row vào table users: email/username thêm bt, trường password: $2a$10$dbQRvatIjQsXEqG3TFsRM.PMyxVy8XTM/jAqVbsgCbW6Dzf35XdOm (tandieu)
# Public api (các api không yêu cầu authorized )
  - Vào class WebSecurityConfig -> hàm configure -> thêm url api muốn public
# Muốn chạy client:
  - Thêm vào DB 2 giới tính, 4 hãng sản xuất, 10 loại giày (id loại giày phải từ 1->10)
  - Vào class Initializer đổi đổi path dẫn đến file excel, FLAG = true cho lần chạy đầu tiên, khi đã có data, sửa FLAG = false
