package member;

import org.springframework.util.SystemPropertyUtils;

public class ServiceImpl implements Service {
	
	private Dao dao;
	
	public ServiceImpl(Dao dao){
		this.dao = dao;
	}

	@Override
	public void addMember(Member m) {
		// TODO Auto-generated method stub
		dao.insert(m);
		System.out.println("ddd");
	}

	@Override
	public String login(Member m) {
		// TODO Auto-generated method stub
		String result = null;
		Member m2 = dao.select(m.getId());
		if(m2 == null){
			result = "incorrect id";
		}else if (!m2.getPwd().equals(m.getPwd())){
			result = "incorrect pwd";
		}
		return result;
	}

	@Override
	public void editMember(Member m) {
		// TODO Auto-generated method stub
		dao.update(m);
	}

	@Override
	public void delMember(String id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Member getMember(String id) {
		// TODO Auto-generated method stub
		Member m = dao.select(id);
		return m;
	}

}
