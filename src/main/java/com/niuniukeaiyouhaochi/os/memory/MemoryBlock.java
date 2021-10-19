package com.niuniukeaiyouhaochi.os.memory;

public class MemoryBlock {
    private Address address;      // 内存块起始位置
    private int endPosition;        // 内存块终止位置
    private String PID;                // 占用内存的进程序号
    private int length;             // 内存块长度
    private boolean isEmpty;        // 占用状态

    public MemoryBlock(int startPosition, int length, boolean isEmpty, String PID){
        address = new Address(startPosition, startPosition + length);
        this.endPosition = startPosition + length;
        this.length = length;
        this.isEmpty = isEmpty;
        this.PID = PID;
    }

    public MemoryBlock(MemoryBlock block,boolean isEmpty){
        this(block.getStartPosition(),block.getLength(),isEmpty, "-1");
    }

    public int getEndPosition() {
        return endPosition;
    }

    public int getStartPosition(){
        return address.getStartAddress();
    }

    public Address getAddress() {
        return address;
    }

    public int getLength(){
        return length;
    }

    public boolean isEmpty(){
        return  isEmpty;
    }

    public boolean equals(MemoryBlock block){
        return block.getLength() == this.getLength() && block.getStartPosition()==this.getStartPosition();
    }
}
