package priv.allen.component.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerHandler extends SimpleChannelInboundHandler<UserParam> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, UserParam msg) throws Exception {
		// 接受客户端对象
		UserParam user = (UserParam) msg;
		System.out.println("客户端发来的消息 : " + user.getId() + ", " + user.getName() + ", " + user.getRequestMessage());
		// 给客户端返回对象
		UserData response = new UserData();
		response.setId(user.getId());
		response.setName("response" + user.getId());
		response.setResponseMessage("响应内容" + user.getId());
		ctx.writeAndFlush(response);
		// 处理完毕，关闭服务端
		// ctx.addListener(ChannelFutureListener.CLOSE);

	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.err.println(cause.getStackTrace());
		ctx.close();
	}

}
