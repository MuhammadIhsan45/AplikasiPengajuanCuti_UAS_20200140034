package rapticon.tk.apkuas;

//membuat class Karyawan
public class Karyawan {
    //Deklarasi tipedata yang digunakan
    String id;
    String nama;
    String bidang;
    String mulai;
    String selesai;
    String keterangan;
    String status;

    public Karyawan() {

    }

    public Karyawan(String id, String nama, String bidang, String mulai, String selesai, String keterangan, String status) {
        this.id = id;
        this.nama = nama;
        this.bidang = bidang;
        this.mulai = mulai;
        this.selesai = selesai;
        this.keterangan = keterangan;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getBidang()
    {
        return bidang;
    }

    public void setBidang(String bidang)
    {
        this.bidang= bidang;
    }

    public String getMulai() {
        return mulai;
    }

    public void setMulai(String mulai) {
        this.mulai = mulai;
    }

    public String getSelesai() {
        return selesai;
    }

    public void setSelesai(String selesai) {
        this.selesai = selesai;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
