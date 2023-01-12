package LogDatas;


public class SignupVo {
   private String id;
   private String pwd;
   private String resi;
   private String name;
   private String PhoneNums;

   public SignupVo() {

   }

   public SignupVo(String id, String pwd, String resi, String name ,String PhoneNums) {
      this.id = id;
      this.pwd = pwd;
      this.resi = resi;
      this.name = name;
      this.PhoneNums = PhoneNums;
   }

   public String getId() {
      return id;
   }

   public String getPwd() {
      return pwd;
   }

   public String getResi() {
      return resi;
   }

   public String getName() {
      return name;
   }
   public String getphonedigits() {
   return PhoneNums;
   }
}