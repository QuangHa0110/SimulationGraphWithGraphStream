package com.nhom6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	private ArrayList<Integer> listPoint = new ArrayList<>();
	private ArrayList<ArrayList<Integer>> listLineBFS = new ArrayList<ArrayList<Integer>>();
	private Queue<Integer> Q = new LinkedList<>();
	private DataInput dataInput;
	private char[] color;
	private int[] p;
	
	public BFS(DataInput dataInput) {
		super();
		this.dataInput = dataInput;
		color = new char[dataInput.getMaxDinh() + 1];
		p = new int[dataInput.getMaxDinh() + 1];
	}

	public void bfs_u(int u) {
		Q.add(u);
		color[u] = 'G';  // G là đã thăm nhưng chưa duyệt xong
	
		while (!Q.isEmpty()) {
			int v = Q.peek();
			Q.poll();
			listPoint.add(v);
			
			for (int i : dataInput.getDanhSachDinh().get(v)) {
				if (color[i] == 'W') {
					ArrayList<Integer> line = new ArrayList<Integer>();
					line.add(v);
					line.add(i);
					p[i]=v;
					listLineBFS.add(line);
					color[i] = 'G';
					Q.add(i);
					
				}
			
			}
			
		}
		
	}
	public static void main(String[] args) {
		String pahtString ="E:\\OneDrive - Hanoi University of Science and Technology\\Desktop\\input.txt";
		DataInput dataInput = new DataInput(pahtString);
	BFS bfs = new BFS(dataInput);
	bfs.bfs(7);
		
	}

	public int[] getP() {
		return p;
	}

	public void setP(int[] p) {
		this.p = p;
	}

	public void bfs(int beginPoint) {
		for (int i = 1; i <= dataInput.getMaxDinh(); i++) {
			color[i] = 'W';
		}
		bfs_u(beginPoint);
		for(int i=1;i<=dataInput.getMaxDinh();i++) {
			if(color[i]=='W') {
				bfs_u(i);
			}
		}
				
	}
	
	
	
	

	

	public ArrayList<Integer> getListPoint() {
		return listPoint;
	}

	public void setListPoint(ArrayList<Integer> listPoint) {
		this.listPoint = listPoint;
	}

	public ArrayList<ArrayList<Integer>> getListLineBFS() {
		return listLineBFS;
	}

	public void setListLineBFS(ArrayList<ArrayList<Integer>> listLineBFS) {
		this.listLineBFS = listLineBFS;
	}

}