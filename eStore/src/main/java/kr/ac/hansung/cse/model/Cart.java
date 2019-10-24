package kr.ac.hansung.cse.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity //빈등록
public class Cart implements Serializable { //object -> json 포맷으로 변환하기 위해 사용
	
	private static final long serialVersionUID = -7383420736137539222L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//mappedBy : foreign key를 가지고 있는 필드명 기입
	//cascade : cart를 저장, 삭제하면 cartItem까지도 같이 저장, 삭제
	//OneToMany의 default는 LAZY!! ManyToOne의 default는 EAGER
	//EAGER : 카드 가져올때 카드 아이템도 가져옴 (LAZY : 필요할 때만 가져옴)
	@OneToMany(mappedBy="cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	
	private double grandTotal;
	
}
