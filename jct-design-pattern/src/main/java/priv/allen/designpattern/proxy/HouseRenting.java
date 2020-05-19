package priv.allen.designpattern.proxy;

/**
 * 房屋出租具体实现类
 * @author Anjin.Ma
 *
 */
public class HouseRenting implements IHouseRenting {

	@Override
	public void rent() {
		System.out.println("renting house..."); //$NON-NLS-1$

	}

}
