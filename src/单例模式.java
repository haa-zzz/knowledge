public class 单例模式 {

    static class DCL{
        private volatile static DCL dcl;
        private DCL(){}
        public static DCL getInstance(){
            if(dcl == null){
                synchronized (DCL.class){
                    if(dcl == null){
                        dcl = new DCL();
                    }
                }
            }
            return dcl;
        }
    }

}
