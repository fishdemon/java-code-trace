package priv.allen.component.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;

public class ClientHandler extends SimpleChannelInboundHandler<UserData> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, UserData msg) throws Exception {
		try {
			UserData user = (UserData) msg;
			System.out
					.println("服务器返回的消息  : " + user.getId() + ", " + user.getName() + ", " + user.getResponseMessage());
		} finally {
			ReferenceCountUtil.release(msg);
		}

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}
	
}
