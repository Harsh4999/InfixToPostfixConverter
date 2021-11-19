package com.harsh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Service;

@Service
public class IntoPostService {

	public String getAnswer(String s) {
		Stack<Character> st = new Stack<Character>();
		List<Character> l = new ArrayList<Character>();
		l.add('(');
		l.add(')');
		l.add('^');
		l.add('/');
		l.add('*');
		l.add('+');
		l.add('-');
		
	
		String ans= "";
		for(int i=0;i<s.length();i++) {
			System.out.println(st);
			char ca = s.charAt(i);
			if(!l.contains(ca)) {
				ans = ans+ca;
			}else {
				if(st.isEmpty()) {
					st.push(ca);
				}else {
					if(ca=='(') {
						st.push(ca);
					}else if(ca==')') {
						for(int j=st.size()-1;j>=0;j--) {
							if(st.peek()=='(') {
								st.pop();
								break;
							}else {
								ans=ans+st.peek();
								st.pop();
							}
							
						}
					}else if(ca=='^') {
						if(st.peek()=='(') {
							st.push(ca);
						}else {
							if(st.peek()=='^') {
								st.push(ca);
							}else {
								st.push(ca);
							}
						}
					}else if(ca=='/') {
						if(st.peek()=='(') {
							st.push(ca);
						}else {
							for(int j=st.size()-1;j>=0;j--) {
								if(st.peek()=='^' || st.peek()=='*' || st.peek()=='/') {
									ans=ans+st.peek();
									st.pop();
								}else {
									st.push(ca);
									break;
								}
							}
							if(st.empty()) {
								st.push(ca);
							}
						}
					}else if(ca=='*') {
						if(st.peek()=='(') {
							st.push(ca);
						}else {
							for(int j=st.size()-1;j>=0;j--) {
								if(st.peek()=='^' || st.peek()=='/' || st.peek()=='*') {
									ans=ans+st.peek();
									st.pop();
								}else {
									st.push(ca);
									break;
								}
							}
							if(st.empty()) {
								st.push(ca);
							}
						}
						
					}else if(ca=='+') {
						if(st.peek()=='(') {
							st.push(ca);
						}else {
							for(int j=st.size()-1;j>=0;j--) {
								if(st.peek()=='/' || st.peek()=='*' || st.peek()=='^' || st.peek()=='-' || st.peek()=='+') {
									ans=ans+st.peek();
									st.pop();
								}else {
									st.push(ca);
									break;
								}
							}
							if(st.empty()) {
								st.push(ca);
							}
						}
					}else {
						if(st.peek()=='(') {
							st.push(ca);
						}else {
							for(int j=st.size()-1;j>=0;j--) {
								if(st.peek()=='/' || st.peek()=='*' || st.peek()=='^' || st.peek()=='+' || st.peek()=='-') {
									ans=ans+st.peek();
									st.pop();
								}else {
									st.push(ca);
									break;
								}
							}
							if(st.empty()) {
								st.push(ca);
							}
						}
					}
				}
			}
		}
		for(int j=st.size()-1;j>=0;j--) {
			ans+=st.peek();
			st.pop();
		}
		System.out.println(ans);
		return ans;
	}
	
}
