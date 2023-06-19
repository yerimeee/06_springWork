package com.kh.spring.common.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

//devForm에서 checkbox로 받은 값들을 DB에 넣을 땐 String으로 넣어야 해서(Array가 없으니까) 변환하기 위한 파일

@MappedTypes(String[].class)	// java type이 String배열을 DB type인 varchar2로 바꾸기
@MappedJdbcTypes(JdbcType.VARCHAR)	// DB type인 varchar2를  java type의 String배열로 바꿀때
public class StringArrayTypeHandler extends BaseTypeHandler<String[]> { 
								//java의 어떤 타입(여기선 String)을 넣어 변환할 건지 상속을 받아 사용
	/*
	 * java객체 -> PreparedStatement값 대입(DB에 넣기 위해)
	 *  - setter
	 *  
	 * ResultSet - > java객체(DB에 있는 값 가져와 사용자에게 보여줘야 해서)
	 *   - getter(3개)
	 */
	// ["java", "c", "python"] => "java,c,python"로 묶어 DB에 넣음
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType)
				//NonNull: 파라미터값이 무조건 있어야 함/ int i: 몇번째 물음표인지 의미
			throws SQLException {
		String value = String.join(",", parameter);
		ps.setString(i, value);
	}

	//  "java,c,python"의 DB 값 가져와서 => ["java", "c", "python"] 배열의 형태로 보여줌
	@Override
	public String[] getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String value = rs.getString(columnName);
		return value != null ? value.split(",") : null;
		//Nullable이라 null 값처리 해줘야하고 ': null;'은 ,단위로 나눴는데 마지막 값엔  ,이 없으니까 삼항연산자 처리
	}

	@Override
	public String[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String value = rs.getString(columnIndex);
		return value != null ? value.split(",") : null;
	}

	@Override
	public String[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String value = cs.getString(columnIndex);
		return value != null ? value.split(",") : null;
	}
}
