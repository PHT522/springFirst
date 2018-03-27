package kh.com.a;

public class Dto {

	private String name;
	private String tel;
	private String email;
	private String birth;
	
	public Dto() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Dto [name=" + name + ", tel=" + tel + ", email=" + email + ", birth=" + birth + "]";
	}
	
	
	
}
