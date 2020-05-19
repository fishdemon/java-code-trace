package priv.allen.javabase.proxy;

/**
 *  机场售票厅
 * @author Allen
 *
 */
public class AirTicketStation implements IPlaneTicket {

	@Override
	public void sellPlaneTicket() {
		System.out.println("AirTicketStation --> sell plane ticket");

	}

	@Override
	public void consultPlaneTicket() {
		System.out.println("AirTicketStation --> consult plane ticket");

	}

	@Override
	public void returnPlaneTicket() {
		System.out.println("AirTicketStation --> return plane ticket");

	}

}
