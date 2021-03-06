package priv.allen.component.netty;

import java.net.InetAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClienHeartBeattHandler extends SimpleChannelInboundHandler<Object> {
	
	 private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	    
	    private ScheduledFuture<?> heartBeat;
		//主动向服务器发送认证信息
	    private InetAddress addr ;
	    
	    private static final String SUCCESS_KEY = "auth_success_key";

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	 private class HeartBeatTask implements Runnable {
	    	private final ChannelHandlerContext ctx;
	 
			public HeartBeatTask(final ChannelHandlerContext ctx) {
			    this.ctx = ctx;
			}
		
			@Override
			public void run() {
				try {
//				    RequestInfo info = new RequestInfo();
//				    //ip
//				    info.setIp(addr.getHostAddress());
//			        Sigar sigar = new Sigar();
//			        //cpu prec
//			        CpuPerc cpuPerc = sigar.getCpuPerc();
//			        HashMap<String, Object> cpuPercMap = new HashMap<String, Object>();
//			        cpuPercMap.put("combined", cpuPerc.getCombined());
//			        cpuPercMap.put("user", cpuPerc.getUser());
//			        cpuPercMap.put("sys", cpuPerc.getSys());
//			        cpuPercMap.put("wait", cpuPerc.getWait());
//			        cpuPercMap.put("idle", cpuPerc.getIdle());
//			        // memory
//			        Mem mem = sigar.getMem();
//					HashMap<String, Object> memoryMap = new HashMap<String, Object>();
//					memoryMap.put("total", mem.getTotal() / 1024L);
//					memoryMap.put("used", mem.getUsed() / 1024L);
//					memoryMap.put("free", mem.getFree() / 1024L);
//					info.setCpuPercMap(cpuPercMap);
//				    info.setMemoryMap(memoryMap);
//				    ctx.writeAndFlush(info);
				    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	 
		    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		    	cause.printStackTrace();
				if (heartBeat != null) {
				    heartBeat.cancel(true);
				    heartBeat = null;
				}
				ctx.fireExceptionCaught(cause);
		    }
		    
		}

}
