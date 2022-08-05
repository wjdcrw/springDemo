package springIOC.construct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class ConstructA {
    private ConstructB constructB;
    private ConstructC constructC;

    /*public ConstructA(){
        System.out.println(0);
    }*/
//    @Autowired
    public ConstructA(ConstructB constructB){
        this.constructB = constructB;
        System.out.println(1);
    }



//    @Autowired(required = false)
    public ConstructA(ConstructB constructB,ConstructC constructC){
        this.constructB = constructB;
        this.constructC = constructC;
        System.out.println(2);
    }

//    @Autowired(required = false)
    public ConstructA(ConstructB constructB1,ConstructC constructC,ConstructB constructB){
        this.constructB = constructB;
        this.constructC = constructC;
        System.out.println(3);
    }

//    @Autowired(required = false)
    public ConstructA(ConstructC constructC,ConstructB constructB){
        this.constructB = constructB;
        this.constructC = constructC;
        System.out.println(4);
    }
}
