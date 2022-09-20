public class BoardVo {
    private int board_seq;
    private String board_subject;
    private String board_contents;
    private int read_cnt;
    private String register_id;
    private String register_date;
    private String modify_id;
    private String modify_date;
    private String delete_yn;
    private String board_pass;

    public int getBoard_seq() {
        return board_seq;
    }

    public BoardVo setBoard_seq(int board_seq) {
        this.board_seq = board_seq;
        return this;
    }

    public String getBoard_subject() {
        return board_subject;
    }

    public BoardVo setBoard_subject(String board_subject) {
        this.board_subject = board_subject;
        return this;
    }

    public String getBoard_contents() {
        return board_contents;
    }

    public BoardVo setBoard_contents(String board_contents) {
        this.board_contents = board_contents;
        return this;
    }

    public int getRead_cnt() {
        return read_cnt;
    }

    public BoardVo setRead_cnt(int read_cnt) {
        this.read_cnt = read_cnt;
        return this;
    }

    public String getRegister_id() {
        return register_id;
    }

    public BoardVo setRegister_id(String register_id) {
        this.register_id = register_id;
        return this;
    }

    public String getRegister_date() {
        return register_date;
    }

    public BoardVo setRegister_date(String register_date) {
        this.register_date = register_date;
        return this;
    }

    public String getModify_id() {
        return modify_id;
    }

    public BoardVo setModify_id(String modify_id) {
        this.modify_id = modify_id;
        return this;
    }

    public String getModify_date() {
        return modify_date;
    }

    public BoardVo setModify_date(String modify_date) {
        this.modify_date = modify_date;
        return this;
    }

    public String getDelete_yn() {
        return delete_yn;
    }

    public BoardVo setDelete_yn(String delete_yn) {
        this.delete_yn = delete_yn;
        return this;
    }

    public String getBoard_pass() {
        return board_pass;
    }

    public BoardVo setBoard_pass(String board_pass) {
        this.board_pass = board_pass;
        return this;
    }
}
