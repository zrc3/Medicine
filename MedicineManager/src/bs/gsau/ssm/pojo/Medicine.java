package bs.gsau.ssm.pojo;

//药品的扩展类
public class Medicine extends BMedicine{

	//关联药店分类
	private BCategory category;

	public BCategory getCategory() {
		return category;
	}

	public void setCategory(BCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Medicine [category=" + category + "]";
	}
	
}
