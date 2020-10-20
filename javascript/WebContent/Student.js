/**
 * 
 */
var com=new Object();
	com.itwill = new Object();
	/*
	var com={};
	com.itwill={};
	*/
	com.itwill.Student=function(id,name,kor,eng,math){
		this.id=id;
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
		this.tot=0;
		this.avg=0.0;
	};
	
	/**********prototype***************
	com.itwill.Student.prototype.calculateTot=function(){
		this.tot=this.kor+this.eng+this.math;
	}
	com.itwill.Student.prototype.calculateAvg=function(){
		this.avg=this.tot/3.0;
	}
	com.itwill.Student.prototype.toString=function(){
		return '[' + this.id + ']' + this.name + "," + this.kor + ","
				+ this.eng + "," + this.math + "," + this.tot + ","
				+ this.avg;
	}
	*/
	/**********prototype[JSON]***************/
	com.itwill.Student.prototype={
			'calculateTot':function(){
				this.tot=this.kor+this.eng+this.math;
			},
			'calculateAvg':function(){
				this.avg=this.tot/3.0;
			},
			'toString':function(){
				return '[' + this.id + ']' + this.name + "," + this.kor + ","
						+ this.eng + "," + this.math + "," + this.tot + ","
						+ this.avg;
			}
			
	};