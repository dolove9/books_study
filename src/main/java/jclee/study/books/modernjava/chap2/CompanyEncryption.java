package jclee.study.books.modernjava.chap2;

public interface CompanyEncryption {
	public byte[] encrypt(byte[] bytes) throws Exception;
	public byte[] decrypt(byte[] bytes) throws Exception;

	//추가
	public boolean isEncoded(byte[] bytes) throws Exception;
}
