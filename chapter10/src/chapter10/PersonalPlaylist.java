package chapter10;

public class PersonalPlaylist extends Playlist {
    public void remove(Song song) {
        getTracks().remove(song);
        getSingers().remove(song.getSinger());  // 부모 클래스의 설계가 바뀌면서 자식 클래스에도 영향을 줄 수 있다.
    }
}
