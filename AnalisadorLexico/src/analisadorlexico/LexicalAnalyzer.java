/* The following code was generated by JFlex 1.6.1 */
package analisadorlexico;

import java.util.ArrayList;

/**
 * This class is a scanner generated by
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1 from the specification file
 * <tt>C:/Users/Matheus
 * Palmeira/Documents/Unesp/2018/Semestre_2/Compiladores/TPI/compiladores-v1/AnalisadorLexico/src/analisadorlexico/language.lex</tt>
 */
class LexicalAnalyzer {

    /**
     * This character denotes the end of file
     */
    public static final int YYEOF = -1;

    /**
     * initial size of the lookahead buffer
     */
    private static final int ZZ_BUFFERSIZE = 16384;

    /**
     * lexical states
     */
    public static final int YYINITIAL = 0;

    /**
     * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
     * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l at the
     * beginning of a line l is of the form l = 2*k, k a non negative integer
     */
    private static final int ZZ_LEXSTATE[] = {
        0, 0
    };

    /**
     * Translates characters to character classes
     */
    private static final String ZZ_CMAP_PACKED
            = "\11\0\1\1\1\46\1\47\1\47\1\45\22\0\1\1\7\0\1\41"
            + "\1\42\1\4\1\3\1\11\1\2\1\12\1\5\1\43\11\40\1\6"
            + "\1\10\1\6\1\7\1\6\2\0\32\37\6\0\1\21\1\22\1\34"
            + "\1\25\1\23\1\16\1\24\1\26\1\13\2\37\1\17\1\36\1\14"
            + "\1\20\1\33\1\37\1\32\1\27\1\15\1\35\1\30\1\31\3\37"
            + "\1\0\1\44\10\0\1\47\u1fa2\0\1\47\1\47\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

    /**
     * Translates characters to character classes
     */
    private static final char[] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

    /**
     * Translates DFA states to action switch labels.
     */
    private static final int[] ZZ_ACTION = zzUnpackAction();

    private static final String ZZ_ACTION_PACKED_0
            = "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\2\7"
            + "\1\10\15\11\1\12\1\13\1\14\1\12\1\0\1\15"
            + "\1\11\1\16\4\11\1\17\13\11\3\0\2\15\1\20"
            + "\4\11\1\21\2\11\1\22\1\11\1\23\1\24\4\11"
            + "\1\25\1\0\1\15\1\26\1\27\5\11\1\30\2\11"
            + "\1\31\2\11\1\32\1\33\1\11\1\34\1\35\1\36"
            + "\1\37\5\11\1\40\1\41\2\11\1\42";

    private static int[] zzUnpackAction() {
        int[] result = new int[101];
        int offset = 0;
        offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackAction(String packed, int offset, int[] result) {
        int i = 0;
        /* index in packed string  */
        int j = offset;
        /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            do {
                result[j++] = value;
            } while (--count > 0);
        }
        return j;
    }

    /**
     * Translates a state to a row index in the transition table
     */
    private static final int[] ZZ_ROWMAP = zzUnpackRowMap();

    private static final String ZZ_ROWMAP_PACKED_0
            = "\0\0\0\50\0\50\0\50\0\50\0\50\0\120\0\170"
            + "\0\50\0\50\0\240\0\310\0\360\0\u0118\0\u0140\0\u0168"
            + "\0\u0190\0\u01b8\0\u01e0\0\u0208\0\u0230\0\u0258\0\u0280\0\u02a8"
            + "\0\50\0\50\0\50\0\u02d0\0\u02f8\0\u0320\0\310\0\u0348"
            + "\0\u0370\0\u0398\0\u03c0\0\310\0\u03e8\0\u0410\0\u0438\0\u0460"
            + "\0\u0488\0\u04b0\0\u04d8\0\u0500\0\u0528\0\u0550\0\u0578\0\u05a0"
            + "\0\u05c8\0\u05f0\0\u0618\0\50\0\310\0\u0640\0\u0668\0\u0690"
            + "\0\u06b8\0\310\0\u06e0\0\u0708\0\u0730\0\u0758\0\310\0\310"
            + "\0\u0780\0\u07a8\0\u07d0\0\u07f8\0\u05a0\0\u0820\0\u05c8\0\310"
            + "\0\310\0\u0848\0\u0870\0\u0898\0\u08c0\0\u08e8\0\310\0\u0910"
            + "\0\u0938\0\310\0\u0960\0\u0988\0\310\0\310\0\u09b0\0\310"
            + "\0\310\0\310\0\310\0\u09d8\0\u0a00\0\u0a28\0\u0a50\0\u0a78"
            + "\0\310\0\310\0\u0aa0\0\u0ac8\0\310";

    private static int[] zzUnpackRowMap() {
        int[] result = new int[101];
        int offset = 0;
        offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackRowMap(String packed, int offset, int[] result) {
        int i = 0;
        /* index in packed string  */
        int j = offset;
        /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int high = packed.charAt(i++) << 16;
            result[j++] = high | packed.charAt(i++);
        }
        return j;
    }

    /**
     * The transition table of the DFA
     */
    private static final int[] ZZ_TRANS = zzUnpackTrans();

    private static final String ZZ_TRANS_PACKED_0
            = "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\2"
            + "\2\11\1\12\1\13\1\14\1\15\1\16\1\14\1\17"
            + "\1\20\1\21\1\22\1\14\1\23\2\14\1\24\1\25"
            + "\1\26\1\27\4\14\1\30\1\31\1\32\1\33\3\3"
            + "\55\0\1\34\1\35\51\0\1\11\53\0\1\14\1\36"
            + "\1\14\1\37\22\14\2\0\1\14\17\0\26\14\2\0"
            + "\1\14\17\0\13\14\1\40\3\14\1\41\6\14\2\0"
            + "\1\14\17\0\4\14\1\42\1\14\1\43\17\14\2\0"
            + "\1\14\17\0\17\14\1\44\6\14\2\0\1\14\17\0"
            + "\1\14\1\45\24\14\2\0\1\14\17\0\5\14\1\46"
            + "\2\14\1\47\15\14\2\0\1\14\17\0\1\14\1\50"
            + "\2\14\1\51\21\14\2\0\1\14\17\0\1\52\25\14"
            + "\2\0\1\14\17\0\6\14\1\53\17\14\2\0\1\14"
            + "\17\0\13\14\1\54\3\14\1\55\6\14\2\0\1\14"
            + "\17\0\10\14\1\56\15\14\2\0\1\14\17\0\17\14"
            + "\1\57\6\14\2\0\1\14\15\0\2\60\25\0\1\30"
            + "\2\0\1\30\1\60\3\0\4\61\1\62\43\61\45\35"
            + "\1\63\1\64\1\35\13\0\2\14\1\65\23\14\2\0"
            + "\1\14\17\0\10\14\1\66\15\14\2\0\1\14\17\0"
            + "\22\14\1\67\3\14\2\0\1\14\17\0\5\14\1\70"
            + "\20\14\2\0\1\14\17\0\4\14\1\71\21\14\2\0"
            + "\1\14\17\0\12\14\1\72\13\14\2\0\1\14\17\0"
            + "\5\14\1\73\20\14\2\0\1\14\17\0\11\14\1\74"
            + "\14\14\2\0\1\14\17\0\12\14\1\75\13\14\2\0"
            + "\1\14\17\0\14\14\1\76\11\14\2\0\1\14\17\0"
            + "\15\14\1\77\10\14\2\0\1\14\17\0\17\14\1\100"
            + "\6\14\2\0\1\14\17\0\1\101\25\14\2\0\1\14"
            + "\17\0\1\102\25\14\2\0\1\14\17\0\6\14\1\103"
            + "\17\14\2\0\1\14\17\0\5\14\1\104\20\14\2\0"
            + "\1\14\44\0\1\105\2\0\1\105\4\0\4\61\1\106"
            + "\47\61\1\106\1\107\42\61\46\0\1\64\14\0\1\14"
            + "\1\110\24\14\2\0\1\14\17\0\10\14\1\111\15\14"
            + "\2\0\1\14\17\0\6\14\1\112\17\14\2\0\1\14"
            + "\17\0\14\14\1\113\11\14\2\0\1\14\17\0\4\14"
            + "\1\114\21\14\2\0\1\14\17\0\1\115\25\14\2\0"
            + "\1\14\17\0\1\116\25\14\2\0\1\14\17\0\10\14"
            + "\1\117\15\14\2\0\1\14\17\0\4\14\1\120\21\14"
            + "\2\0\1\14\17\0\2\14\1\121\23\14\2\0\1\14"
            + "\17\0\12\14\1\122\13\14\2\0\1\14\17\0\11\14"
            + "\1\123\7\14\1\124\4\14\2\0\1\14\4\0\4\61"
            + "\1\106\1\64\42\61\13\0\2\14\1\125\23\14\2\0"
            + "\1\14\17\0\10\14\1\126\15\14\2\0\1\14\17\0"
            + "\10\14\1\127\15\14\2\0\1\14\17\0\1\14\1\130"
            + "\24\14\2\0\1\14\17\0\3\14\1\131\22\14\2\0"
            + "\1\14\17\0\10\14\1\132\15\14\2\0\1\14\17\0"
            + "\10\14\1\133\15\14\2\0\1\14\17\0\17\14\1\134"
            + "\6\14\2\0\1\14\17\0\10\14\1\135\15\14\2\0"
            + "\1\14\17\0\6\14\1\136\17\14\2\0\1\14\17\0"
            + "\6\14\1\137\17\14\2\0\1\14\17\0\12\14\1\140"
            + "\13\14\2\0\1\14\17\0\1\14\1\141\24\14\2\0"
            + "\1\14\17\0\23\14\1\142\2\14\2\0\1\14\17\0"
            + "\22\14\1\143\3\14\2\0\1\14\17\0\17\14\1\144"
            + "\6\14\2\0\1\14\17\0\10\14\1\145\15\14\2\0"
            + "\1\14\4\0";

    private static int[] zzUnpackTrans() {
        int[] result = new int[2800];
        int offset = 0;
        offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackTrans(String packed, int offset, int[] result) {
        int i = 0;
        /* index in packed string  */
        int j = offset;
        /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            value--;
            do {
                result[j++] = value;
            } while (--count > 0);
        }
        return j;
    }


    /* error codes */
    private static final int ZZ_UNKNOWN_ERROR = 0;
    private static final int ZZ_NO_MATCH = 1;
    private static final int ZZ_PUSHBACK_2BIG = 2;

    /* error messages for the codes above */
    private static final String ZZ_ERROR_MSG[] = {
        "Unknown internal scanner error",
        "Error: could not match input",
        "Error: pushback value was too large"
    };

    /**
     * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
     */
    private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();

    private static final String ZZ_ATTRIBUTE_PACKED_0
            = "\1\0\5\11\2\1\2\11\16\1\3\11\1\0\23\1"
            + "\3\0\1\1\1\11\21\1\1\0\37\1";

    private static int[] zzUnpackAttribute() {
        int[] result = new int[101];
        int offset = 0;
        offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackAttribute(String packed, int offset, int[] result) {
        int i = 0;
        /* index in packed string  */
        int j = offset;
        /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            do {
                result[j++] = value;
            } while (--count > 0);
        }
        return j;
    }

    /**
     * the input device
     */
    private java.io.Reader zzReader;

    /**
     * the current state of the DFA
     */
    private int zzState;

    /**
     * the current lexical state
     */
    private int zzLexicalState = YYINITIAL;

    /**
     * this buffer contains the current text to be matched and is the source of
     * the yytext() string
     */
    private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

    /**
     * the textposition at the last accepting state
     */
    private int zzMarkedPos;

    /**
     * the current text position in the buffer
     */
    private int zzCurrentPos;

    /**
     * startRead marks the beginning of the yytext() string in the buffer
     */
    private int zzStartRead;

    /**
     * endRead marks the last character in the buffer, that has been read from
     * input
     */
    private int zzEndRead;

    /**
     * number of newlines encountered up to the start of the matched text
     */
    private int yyline;

    /**
     * the number of characters up to the start of the matched text
     */
    private int yychar;

    /**
     * the number of characters from the last newline up to the start of the
     * matched text
     */
    private int yycolumn;

    /**
     * zzAtBOL == true <=> the scanner is currently at the beginning of a line
     */
    private boolean zzAtBOL = true;

    /**
     * zzAtEOF == true <=> the scanner is at the EOF
     */
    private boolean zzAtEOF;

    /**
     * denotes if the user-EOF-code has already been executed
     */
    private boolean zzEOFDone;

    /**
     * The number of occupied positions in zzBuffer beyond zzEndRead. When a
     * lead/high surrogate has been read from the input stream into the final
     * zzBuffer position, this will have a value of 1; otherwise, it will have a
     * value of 0.
     */
    private int zzFinalHighSurrogate = 0;

    /* user code: */
    public ArrayList<Simbolo> tabelaSimbolos;

    public int linha;
    public int coluna;

    LexicalAnalyzer(java.io.Reader in, ArrayList<Simbolo> s) {
        this.zzReader = in;
        this.tabelaSimbolos = s;
        this.linha = 0;
        this.coluna = 0;

    }

    private void imprimir(String descricao, String lexema) {
        Simbolo atual = new Simbolo();
        String[] list = descricao.split(",");

        atual.setLinha(this.yyline);
        atual.setColuna(this.yycolumn);
        atual.setDescricao(list[1]);
        atual.setToken(list[0]);
        atual.setLexema(lexema);

        this.tabelaSimbolos.add(atual);
        //System.out.println(lexema + " - " + descricao);
    }

    /**
     * Creates a new scanner
     *
     * @param in the java.io.Reader to read input from.
     */
    LexicalAnalyzer(java.io.Reader in) {
        this.zzReader = in;
    }

    /**
     * Unpacks the compressed character translation table.
     *
     * @param packed the packed character translation table
     * @return the unpacked character translation table
     */
    private static char[] zzUnpackCMap(String packed) {
        char[] map = new char[0x110000];
        int i = 0;
        /* index in packed string  */
        int j = 0;
        /* index in unpacked array */
        while (i < 148) {
            int count = packed.charAt(i++);
            char value = packed.charAt(i++);
            do {
                map[j++] = value;
            } while (--count > 0);
        }
        return map;
    }

    /**
     * Refills the input buffer.
     *
     * @return      <code>false</code>, iff there was new input.
     *
     * @exception java.io.IOException if any I/O-Error occurs
     */
    private boolean zzRefill() throws java.io.IOException {

        /* first: make room (if you can) */
        if (zzStartRead > 0) {
            zzEndRead += zzFinalHighSurrogate;
            zzFinalHighSurrogate = 0;
            System.arraycopy(zzBuffer, zzStartRead,
                    zzBuffer, 0,
                    zzEndRead - zzStartRead);

            /* translate stored positions */
            zzEndRead -= zzStartRead;
            zzCurrentPos -= zzStartRead;
            zzMarkedPos -= zzStartRead;
            zzStartRead = 0;
        }

        /* is the buffer big enough? */
        if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
            /* if not: blow it up */
            char newBuffer[] = new char[zzBuffer.length * 2];
            System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
            zzBuffer = newBuffer;
            zzEndRead += zzFinalHighSurrogate;
            zzFinalHighSurrogate = 0;
        }

        /* fill the buffer with new input */
        int requested = zzBuffer.length - zzEndRead;
        int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

        /* not supposed to occur according to specification of java.io.Reader */
        if (numRead == 0) {
            throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
        }
        if (numRead > 0) {
            zzEndRead += numRead;
            /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
            if (numRead == requested) {
                if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
                    --zzEndRead;
                    zzFinalHighSurrogate = 1;
                }
            }
            /* potentially more input available */
            return false;
        }

        /* numRead < 0 ==> end of stream */
        return true;
    }

    /**
     * Closes the input stream.
     */
    public final void yyclose() throws java.io.IOException {
        zzAtEOF = true;
        /* indicate end of file */
        zzEndRead = zzStartRead;
        /* invalidate buffer    */

        if (zzReader != null) {
            zzReader.close();
        }
    }

    /**
     * Resets the scanner to read from a new input stream. Does not close the
     * old reader.
     *
     * All internal variables are reset, the old input stream
     * <b>cannot</b> be reused (internal buffer is discarded and lost). Lexical
     * state is set to <tt>ZZ_INITIAL</tt>.
     *
     * Internal scan buffer is resized down to its initial length, if it has
     * grown.
     *
     * @param reader the new input stream
     */
    public final void yyreset(java.io.Reader reader) {
        zzReader = reader;
        zzAtBOL = true;
        zzAtEOF = false;
        zzEOFDone = false;
        zzEndRead = zzStartRead = 0;
        zzCurrentPos = zzMarkedPos = 0;
        zzFinalHighSurrogate = 0;
        yyline = yychar = yycolumn = 0;
        zzLexicalState = YYINITIAL;
        if (zzBuffer.length > ZZ_BUFFERSIZE) {
            zzBuffer = new char[ZZ_BUFFERSIZE];
        }
    }

    /**
     * Returns the current lexical state.
     */
    public final int yystate() {
        return zzLexicalState;
    }

    /**
     * Enters a new lexical state
     *
     * @param newState the new lexical state
     */
    public final void yybegin(int newState) {
        zzLexicalState = newState;
    }

    /**
     * Returns the text matched by the current regular expression.
     */
    public final String yytext() {
        return new String(zzBuffer, zzStartRead, zzMarkedPos - zzStartRead);
    }

    /**
     * Returns the character at position <tt>pos</tt> from the matched text.
     *
     * It is equivalent to yytext().charAt(pos), but faster
     *
     * @param pos the position of the character to fetch. A value from 0 to
     * yylength()-1.
     *
     * @return the character at position pos
     */
    public final char yycharat(int pos) {
        return zzBuffer[zzStartRead + pos];
    }

    /**
     * Returns the length of the matched text region.
     */
    public final int yylength() {
        return zzMarkedPos - zzStartRead;
    }

    /**
     * Reports an error that occured while scanning.
     *
     * In a wellformed scanner (no or only correct usage of yypushback(int) and
     * a match-all fallback rule) this method will only be called with things
     * that "Can't Possibly Happen". If this method is called, something is
     * seriously wrong (e.g. a JFlex bug producing a faulty scanner etc.).
     *
     * Usual syntax/scanner level error handling should be done in error
     * fallback rules.
     *
     * @param errorCode the code of the errormessage to display
     */
    private void zzScanError(int errorCode) {
        String message;
        try {
            message = ZZ_ERROR_MSG[errorCode];
        } catch (ArrayIndexOutOfBoundsException e) {
            message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
        }

        throw new Error(message);
    }

    /**
     * Pushes the specified amount of characters back into the input stream.
     *
     * They will be read again by then next call of the scanning method
     *
     * @param number the number of characters to be read again. This number must
     * not be greater than yylength()!
     */
    public void yypushback(int number) {
        if (number > yylength()) {
            zzScanError(ZZ_PUSHBACK_2BIG);
        }

        zzMarkedPos -= number;
    }

    /**
     * Resumes scanning until the next regular expression is matched, the end of
     * input is encountered or an I/O-Error occurs.
     *
     * @return the next token
     * @exception java.io.IOException if any I/O-Error occurs
     */
    public void yylex() throws java.io.IOException {
        int zzInput;
        int zzAction;

        // cached fields:
        int zzCurrentPosL;
        int zzMarkedPosL;
        int zzEndReadL = zzEndRead;
        char[] zzBufferL = zzBuffer;
        char[] zzCMapL = ZZ_CMAP;

        int[] zzTransL = ZZ_TRANS;
        int[] zzRowMapL = ZZ_ROWMAP;
        int[] zzAttrL = ZZ_ATTRIBUTE;

        while (true) {
            zzMarkedPosL = zzMarkedPos;

            boolean zzR = false;
            int zzCh;
            int zzCharCount;
            for (zzCurrentPosL = zzStartRead;
                    zzCurrentPosL < zzMarkedPosL;
                    zzCurrentPosL += zzCharCount) {
                zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
                zzCharCount = Character.charCount(zzCh);
                switch (zzCh) {
                    case '\u000B':
                    case '\u000C':
                    case '\u0085':
                    case '\u2028':
                    case '\u2029':
                        yyline++;
                        yycolumn = 0;
                        zzR = false;
                        break;
                    case '\r':
                        yyline++;
                        yycolumn = 0;
                        zzR = true;
                        break;
                    case '\n':
                        if (zzR) {
                            zzR = false;
                        } else {
                            yyline++;
                            yycolumn = 0;
                        }
                        break;
                    default:
                        zzR = false;
                        yycolumn += zzCharCount;
                }
            }

            if (zzR) {
                // peek one character ahead if it is \n (if we have counted one line too much)
                boolean zzPeek;
                if (zzMarkedPosL < zzEndReadL) {
                    zzPeek = zzBufferL[zzMarkedPosL] == '\n';
                } else if (zzAtEOF) {
                    zzPeek = false;
                } else {
                    boolean eof = zzRefill();
                    zzEndReadL = zzEndRead;
                    zzMarkedPosL = zzMarkedPos;
                    zzBufferL = zzBuffer;
                    if (eof) {
                        zzPeek = false;
                    } else {
                        zzPeek = zzBufferL[zzMarkedPosL] == '\n';
                    }
                }
                if (zzPeek) {
                    yyline--;
                }
            }
            zzAction = -1;

            zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

            zzState = ZZ_LEXSTATE[zzLexicalState];

            // set up zzAction for empty match case:
            int zzAttributes = zzAttrL[zzState];
            if ((zzAttributes & 1) == 1) {
                zzAction = zzState;
            }

            zzForAction:
            {
                while (true) {

                    if (zzCurrentPosL < zzEndReadL) {
                        zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
                        zzCurrentPosL += Character.charCount(zzInput);
                    } else if (zzAtEOF) {
                        zzInput = YYEOF;
                        break zzForAction;
                    } else {
                        // store back cached positions
                        zzCurrentPos = zzCurrentPosL;
                        zzMarkedPos = zzMarkedPosL;
                        boolean eof = zzRefill();
                        // get translated positions and possibly new buffer
                        zzCurrentPosL = zzCurrentPos;
                        zzMarkedPosL = zzMarkedPos;
                        zzBufferL = zzBuffer;
                        zzEndReadL = zzEndRead;
                        if (eof) {
                            zzInput = YYEOF;
                            break zzForAction;
                        } else {
                            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
                            zzCurrentPosL += Character.charCount(zzInput);
                        }
                    }
                    int zzNext = zzTransL[zzRowMapL[zzState] + zzCMapL[zzInput]];
                    if (zzNext == -1) {
                        break zzForAction;
                    }
                    zzState = zzNext;

                    zzAttributes = zzAttrL[zzState];
                    if ((zzAttributes & 1) == 1) {
                        zzAction = zzState;
                        zzMarkedPosL = zzCurrentPosL;
                        if ((zzAttributes & 8) == 8) {
                            break zzForAction;
                        }
                    }

                }
            }

            // store back cached position
            zzMarkedPos = zzMarkedPosL;

            if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
                zzAtEOF = true;
                return;
            } else {
                switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
                    case 1: {
                        imprimir("INVÁLIDO,Caractere inválido", yytext());
                    }
                    case 35:
                        break;
                    case 2: {
                    }
                    case 36:
                        break;
                    case 3: {
                        imprimir("OP_SUB,Operador de subtração", yytext());
                    }
                    case 37:
                        break;
                    case 4: {
                        imprimir("OP_SOMA,Operador de soma", yytext());
                    }
                    case 38:
                        break;
                    case 5: {
                        imprimir("OP_MULT,Operador de multiplicação", yytext());
                    }
                    case 39:
                        break;
                    case 6: {
                        imprimir("OP_DIV,Operador de divisão", yytext());
                    }
                    case 40:
                        break;
                    case 7: {
                        imprimir("SIMBOLO_ESPECIAL, Simbolo Especial", yytext());
                    }
                    case 41:
                        break;
                    case 8: {
                        imprimir("SIMBOLO_FINAL, Ponto final", yytext());
                    }
                    case 42:
                        break;
                    case 9: {
                        imprimir("IDENTIFICADOR, Palavra é variável", yytext());
                    }
                    case 43:
                        break;
                    case 10: {

                        try {
                            int num = Integer.parseInt(yytext());
                            if (num < 2147483646) {
                                imprimir("NUMERO_INT,Número Inteiro", yytext());
                            }
                        } catch (Exception e) {
                            imprimir("INVÁLIDO,Inteiro maior que o Limite", yytext());
                            System.out.println(e.getMessage());
                        }
                    }
                    case 44:
                        break;
                    case 11: {
                        imprimir("AP,Abre parêntese", yytext());
                    }
                    case 45:
                        break;
                    case 12: {
                        imprimir("FP,Fecha parêntese", yytext());
                    }
                    case 46:
                        break;
                    case 13: {
                        imprimir("COMENTÁRIO, Comentário inserido", yytext());
                    }
                    case 47:
                        break;
                    case 14: {
                        imprimir("PALAVRA_RESERVADA_IF, Palavra 'if'", yytext());
                    }
                    case 48:
                        break;
                    case 15: {
                        imprimir("PALAVRA_RESERVADA_OR, Palavra 'or'", yytext());
                    }
                    case 49:
                        break;
                    case 16: {
                        imprimir("PALAVRA_RESERVADA_INT,Número Inteiro", yytext());
                    }
                    case 50:
                        break;
                    case 17: {
                        imprimir("PALAVRA_RESERVADA_AND, Palavra 'and'", yytext());
                    }
                    case 51:
                        break;
                    case 18: {
                        imprimir("PALAVRA_RESERVADA_END, Palavra 'end'", yytext());
                    }
                    case 52:
                        break;
                    case 19: {
                        imprimir("PALAVRA_RESERVADA_DIV, Palavra 'div'", yytext());
                    }
                    case 53:
                        break;
                    case 20: {
                        imprimir("PALAVRA_RESERVADA_VAR, Palavra 'var'", yytext());
                    }
                    case 54:
                        break;
                    case 21: {
                        imprimir("NUMERO_REAL, Número real", yytext());
                    }
                    case 55:
                        break;
                    case 22: {
                        imprimir("PALAVRA_RESERVADA_THEN, Palavra 'then'", yytext());
                    }
                    case 56:
                        break;
                    case 23: {
                        imprimir("PALAVRA_RESERVADA_TRUE, Palavra 'true'", yytext());
                    }
                    case 57:
                        break;
                    case 24: {
                        imprimir("PALAVRA_RESERVADA_ELSE, Palavra 'else'", yytext());
                    }
                    case 58:
                        break;
                    case 25: {
                        imprimir("PALAVRA_RESERVADA_READ, read", yytext());
                    }
                    case 59:
                        break;
                    case 26: {
                        imprimir("PALAVRA_RESERVADA_FLOAT,Número Real", yytext());
                    }
                    case 60:
                        break;
                    case 27: {
                        imprimir("PALAVRA_RESERVADA_FALSE, Palavra 'false'", yytext());
                    }
                    case 61:
                        break;
                    case 28: {
                        imprimir("PALAVRA_RESERVADA_BEGIN, Palavra 'begin'", yytext());
                    }
                    case 62:
                        break;
                    case 29: {
                        imprimir("PALAVRA_RESERVADA_ENDIF, Palavra 'endif'", yytext());
                    }
                    case 63:
                        break;
                    case 30: {
                        imprimir("PALAVRA_RESERVADA_WHILE, Palavra 'while'", yytext());
                    }
                    case 64:
                        break;
                    case 31: {
                        imprimir("PALAVRA_RESERVADA_WRITE, write", yytext());
                    }
                    case 65:
                        break;
                    case 32: {
                        imprimir("PALAVRA_RESERVADA_BOOLEAN, Palavra 'boolean'", yytext());
                    }
                    case 66:
                        break;
                    case 33: {
                        imprimir("PALAVRA_RESERVADA_PROGRAM, Palavra 'program'", yytext());
                    }
                    case 67:
                        break;
                    case 34: {
                        imprimir("PALAVRA_RESERVADA_PROCEDURE, Palavra 'procedure'", yytext());
                    }
                    case 68:
                        break;
                    default:
                        zzScanError(ZZ_NO_MATCH);
                }
            }
        }
    }

}
