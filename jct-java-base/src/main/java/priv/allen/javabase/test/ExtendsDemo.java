/**
 * 
 */
package priv.allen.javabase.test;

/**
 * @author Ma anjin 
 *
 */
public class ExtendsDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Teacher t = new Teacher();
		t.setName("Allen"); //$NON-NLS-1$
		t.setUserName("UserName"); //$NON-NLS-1$
		
		System.out.println(t.getName());
		System.out.println(t.getUserName());
		
		System.out.println(t.name);
		System.out.println(((User)t).name);
	}
	
	static class User {
		private String name;


		/**
		 * @return the name
		 */
		public String getUserName() {
			return name;
		}


		/**
		 * @param name the name to set
		 */
		public void setUserName(String name) {
			this.name = name;
		}
		
	}
	
	static class Teacher extends User {
		private String name;

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		
		
	}

}
