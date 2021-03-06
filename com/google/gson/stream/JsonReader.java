package com.google.gson.stream;

import com.avg.toolkit.ITKSvc;
import com.google.ads.AdSize;
import com.google.android.gms.location.LocationRequest;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class JsonReader implements Closeable {
    private static final String FALSE = "false";
    private static final char[] NON_EXECUTE_PREFIX;
    private static final String TRUE = "true";
    private final char[] buffer;
    private int bufferStartColumn;
    private int bufferStartLine;
    private final Reader in;
    private boolean lenient;
    private int limit;
    private String name;
    private int pos;
    private boolean skipping;
    private JsonScope[] stack;
    private int stackSize;
    private final StringPool stringPool;
    private JsonToken token;
    private String value;
    private int valueLength;
    private int valuePos;

    /* renamed from: com.google.gson.stream.JsonReader.1 */
    static class C24311 extends JsonReaderInternalAccess {
        C24311() {
        }

        public void promoteNameToValue(JsonReader reader) {
            if (reader instanceof JsonTreeReader) {
                ((JsonTreeReader) reader).promoteNameToValue();
                return;
            }
            reader.peek();
            if (reader.token != JsonToken.NAME) {
                throw new IllegalStateException("Expected a name but was " + reader.peek() + " " + " at line " + reader.getLineNumber() + " column " + reader.getColumnNumber());
            }
            reader.value = reader.name;
            reader.name = null;
            reader.token = JsonToken.STRING;
        }
    }

    /* renamed from: com.google.gson.stream.JsonReader.2 */
    static /* synthetic */ class C24322 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonScope;

        static {
            $SwitchMap$com$google$gson$stream$JsonScope = new int[JsonScope.values().length];
            try {
                $SwitchMap$com$google$gson$stream$JsonScope[JsonScope.EMPTY_DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonScope[JsonScope.EMPTY_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonScope[JsonScope.NONEMPTY_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonScope[JsonScope.EMPTY_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonScope[JsonScope.DANGLING_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonScope[JsonScope.NONEMPTY_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonScope[JsonScope.NONEMPTY_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonScope[JsonScope.CLOSED.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    static {
        NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
        JsonReaderInternalAccess.INSTANCE = new C24311();
    }

    public JsonReader(Reader in) {
        this.stringPool = new StringPool();
        this.lenient = false;
        this.buffer = new char[1024];
        this.pos = 0;
        this.limit = 0;
        this.bufferStartLine = 1;
        this.bufferStartColumn = 1;
        this.stack = new JsonScope[32];
        this.stackSize = 0;
        push(JsonScope.EMPTY_DOCUMENT);
        this.skipping = false;
        if (in == null) {
            throw new NullPointerException("in == null");
        }
        this.in = in;
    }

    public final void setLenient(boolean lenient) {
        this.lenient = lenient;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public void beginArray() {
        expect(JsonToken.BEGIN_ARRAY);
    }

    public void endArray() {
        expect(JsonToken.END_ARRAY);
    }

    public void beginObject() {
        expect(JsonToken.BEGIN_OBJECT);
    }

    public void endObject() {
        expect(JsonToken.END_OBJECT);
    }

    private void expect(JsonToken expected) {
        peek();
        if (this.token != expected) {
            throw new IllegalStateException("Expected " + expected + " but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        advance();
    }

    public boolean hasNext() {
        peek();
        return (this.token == JsonToken.END_OBJECT || this.token == JsonToken.END_ARRAY) ? false : true;
    }

    public JsonToken peek() {
        if (this.token != null) {
            return this.token;
        }
        switch (C24322.$SwitchMap$com$google$gson$stream$JsonScope[this.stack[this.stackSize - 1].ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                if (this.lenient) {
                    consumeNonExecutePrefix();
                }
                this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_DOCUMENT;
                JsonToken firstToken = nextValue();
                if (this.lenient || this.token == JsonToken.BEGIN_ARRAY || this.token == JsonToken.BEGIN_OBJECT) {
                    return firstToken;
                }
                throw new IOException("Expected JSON document to start with '[' or '{' but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
            case Base64.NO_WRAP /*2*/:
                return nextInArray(true);
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return nextInArray(false);
            case Base64.CRLF /*4*/:
                return nextInObject(true);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return objectValue();
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return nextInObject(false);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                if (nextNonWhitespace(false) == -1) {
                    return JsonToken.END_DOCUMENT;
                }
                this.pos--;
                if (this.lenient) {
                    return nextValue();
                }
                throw syntaxError("Expected EOF");
            case Base64.URL_SAFE /*8*/:
                throw new IllegalStateException("JsonReader is closed");
            default:
                throw new AssertionError();
        }
    }

    private void consumeNonExecutePrefix() {
        nextNonWhitespace(true);
        this.pos--;
        if (this.pos + NON_EXECUTE_PREFIX.length <= this.limit || fillBuffer(NON_EXECUTE_PREFIX.length)) {
            int i = 0;
            while (i < NON_EXECUTE_PREFIX.length) {
                if (this.buffer[this.pos + i] == NON_EXECUTE_PREFIX[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.pos += NON_EXECUTE_PREFIX.length;
        }
    }

    private JsonToken advance() {
        peek();
        JsonToken result = this.token;
        this.token = null;
        this.value = null;
        this.name = null;
        return result;
    }

    public String nextName() {
        peek();
        if (this.token != JsonToken.NAME) {
            throw new IllegalStateException("Expected a name but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        String result = this.name;
        advance();
        return result;
    }

    public String nextString() {
        peek();
        if (this.token == JsonToken.STRING || this.token == JsonToken.NUMBER) {
            String result = this.value;
            advance();
            return result;
        }
        throw new IllegalStateException("Expected a string but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber());
    }

    public boolean nextBoolean() {
        peek();
        if (this.token != JsonToken.BOOLEAN) {
            throw new IllegalStateException("Expected a boolean but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        boolean result = this.value == TRUE;
        advance();
        return result;
    }

    public void nextNull() {
        peek();
        if (this.token != JsonToken.NULL) {
            throw new IllegalStateException("Expected null but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        advance();
    }

    public double nextDouble() {
        peek();
        if (this.token == JsonToken.STRING || this.token == JsonToken.NUMBER) {
            double result = Double.parseDouble(this.value);
            if (result >= 1.0d && this.value.startsWith(ITKSvc.CODEREVISION)) {
                throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
            } else if (this.lenient || !(Double.isNaN(result) || Double.isInfinite(result))) {
                advance();
                return result;
            } else {
                throw new MalformedJsonException("JSON forbids NaN and infinities: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
            }
        }
        throw new IllegalStateException("Expected a double but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
    }

    public long nextLong() {
        peek();
        if (this.token == JsonToken.STRING || this.token == JsonToken.NUMBER) {
            long result;
            try {
                result = Long.parseLong(this.value);
            } catch (NumberFormatException e) {
                double asDouble = Double.parseDouble(this.value);
                result = (long) asDouble;
                if (((double) result) != asDouble) {
                    throw new NumberFormatException("Expected a long but was " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
                }
            }
            if (result < 1 || !this.value.startsWith(ITKSvc.CODEREVISION)) {
                advance();
                return result;
            }
            throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        throw new IllegalStateException("Expected a long but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
    }

    public int nextInt() {
        peek();
        if (this.token == JsonToken.STRING || this.token == JsonToken.NUMBER) {
            int result;
            try {
                result = Integer.parseInt(this.value);
            } catch (NumberFormatException e) {
                double asDouble = Double.parseDouble(this.value);
                result = (int) asDouble;
                if (((double) result) != asDouble) {
                    throw new NumberFormatException("Expected an int but was " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
                }
            }
            if (((long) result) < 1 || !this.value.startsWith(ITKSvc.CODEREVISION)) {
                advance();
                return result;
            }
            throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        throw new IllegalStateException("Expected an int but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
    }

    public void close() {
        this.value = null;
        this.token = null;
        this.stack[0] = JsonScope.CLOSED;
        this.stackSize = 1;
        this.in.close();
    }

    public void skipValue() {
        this.skipping = true;
        int count = 0;
        while (true) {
            try {
                JsonToken token = advance();
                if (token == JsonToken.BEGIN_ARRAY || token == JsonToken.BEGIN_OBJECT) {
                    count++;
                    continue;
                } else if (token == JsonToken.END_ARRAY || token == JsonToken.END_OBJECT) {
                    count--;
                    continue;
                }
                if (count == 0) {
                    break;
                }
            } finally {
                this.skipping = false;
            }
        }
    }

    private void push(JsonScope newTop) {
        if (this.stackSize == this.stack.length) {
            JsonScope[] newStack = new JsonScope[(this.stackSize * 2)];
            System.arraycopy(this.stack, 0, newStack, 0, this.stackSize);
            this.stack = newStack;
        }
        JsonScope[] jsonScopeArr = this.stack;
        int i = this.stackSize;
        this.stackSize = i + 1;
        jsonScopeArr[i] = newTop;
    }

    private JsonToken nextInArray(boolean firstElement) {
        JsonToken jsonToken;
        if (firstElement) {
            this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_ARRAY;
        } else {
            switch (nextNonWhitespace(true)) {
                case 44:
                    break;
                case 59:
                    checkLenient();
                    break;
                case 93:
                    this.stackSize--;
                    jsonToken = JsonToken.END_ARRAY;
                    this.token = jsonToken;
                    return jsonToken;
                default:
                    throw syntaxError("Unterminated array");
            }
        }
        switch (nextNonWhitespace(true)) {
            case 44:
            case 59:
                break;
            case 93:
                if (firstElement) {
                    this.stackSize--;
                    jsonToken = JsonToken.END_ARRAY;
                    this.token = jsonToken;
                    return jsonToken;
                }
                break;
            default:
                this.pos--;
                return nextValue();
        }
        checkLenient();
        this.pos--;
        this.value = "null";
        jsonToken = JsonToken.NULL;
        this.token = jsonToken;
        return jsonToken;
    }

    private JsonToken nextInObject(boolean firstElement) {
        JsonToken jsonToken;
        if (firstElement) {
            switch (nextNonWhitespace(true)) {
                case 125:
                    this.stackSize--;
                    jsonToken = JsonToken.END_OBJECT;
                    this.token = jsonToken;
                    return jsonToken;
                default:
                    this.pos--;
                    break;
            }
        }
        switch (nextNonWhitespace(true)) {
            case 44:
            case 59:
                break;
            case 125:
                this.stackSize--;
                jsonToken = JsonToken.END_OBJECT;
                this.token = jsonToken;
                return jsonToken;
            default:
                throw syntaxError("Unterminated object");
        }
        int quote = nextNonWhitespace(true);
        switch (quote) {
            case 34:
                break;
            case 39:
                checkLenient();
                break;
            default:
                checkLenient();
                this.pos--;
                this.name = nextLiteral(false);
                if (this.name.length() == 0) {
                    throw syntaxError("Expected name");
                }
                break;
        }
        this.name = nextString((char) quote);
        this.stack[this.stackSize - 1] = JsonScope.DANGLING_NAME;
        jsonToken = JsonToken.NAME;
        this.token = jsonToken;
        return jsonToken;
    }

    private JsonToken objectValue() {
        switch (nextNonWhitespace(true)) {
            case 58:
                break;
            case 61:
                checkLenient();
                if ((this.pos < this.limit || fillBuffer(1)) && this.buffer[this.pos] == '>') {
                    this.pos++;
                    break;
                }
            default:
                throw syntaxError("Expected ':'");
        }
        this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_OBJECT;
        return nextValue();
    }

    private JsonToken nextValue() {
        JsonToken jsonToken;
        int c = nextNonWhitespace(true);
        switch (c) {
            case 34:
                break;
            case 39:
                checkLenient();
                break;
            case 91:
                push(JsonScope.EMPTY_ARRAY);
                jsonToken = JsonToken.BEGIN_ARRAY;
                this.token = jsonToken;
                return jsonToken;
            case 123:
                push(JsonScope.EMPTY_OBJECT);
                jsonToken = JsonToken.BEGIN_OBJECT;
                this.token = jsonToken;
                return jsonToken;
            default:
                this.pos--;
                return readLiteral();
        }
        this.value = nextString((char) c);
        jsonToken = JsonToken.STRING;
        this.token = jsonToken;
        return jsonToken;
    }

    private boolean fillBuffer(int minimum) {
        char[] buffer = this.buffer;
        int line = this.bufferStartLine;
        int column = this.bufferStartColumn;
        int p = this.pos;
        for (int i = 0; i < p; i++) {
            if (buffer[i] == '\n') {
                line++;
                column = 1;
            } else {
                column++;
            }
        }
        this.bufferStartLine = line;
        this.bufferStartColumn = column;
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(buffer, this.pos, buffer, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int total = this.in.read(buffer, this.limit, buffer.length - this.limit);
            if (total == -1) {
                return false;
            }
            this.limit += total;
            if (this.bufferStartLine == 1 && this.bufferStartColumn == 1 && this.limit > 0 && buffer[0] == '\ufeff') {
                this.pos++;
                this.bufferStartColumn--;
            }
        } while (this.limit < minimum);
        return true;
    }

    private int getLineNumber() {
        int result = this.bufferStartLine;
        for (int i = 0; i < this.pos; i++) {
            if (this.buffer[i] == '\n') {
                result++;
            }
        }
        return result;
    }

    private int getColumnNumber() {
        int result = this.bufferStartColumn;
        for (int i = 0; i < this.pos; i++) {
            if (this.buffer[i] == '\n') {
                result = 1;
            } else {
                result++;
            }
        }
        return result;
    }

    private int nextNonWhitespace(boolean throwOnEof) {
        char[] buffer = this.buffer;
        int p = this.pos;
        int l = this.limit;
        while (true) {
            if (p == l) {
                this.pos = p;
                if (fillBuffer(1)) {
                    p = this.pos;
                    l = this.limit;
                } else if (!throwOnEof) {
                    return -1;
                } else {
                    throw new EOFException("End of input at line " + getLineNumber() + " column " + getColumnNumber());
                }
            }
            int p2 = p + 1;
            int c = buffer[p];
            switch (c) {
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                    p = p2;
                    break;
                case 35:
                    this.pos = p2;
                    checkLenient();
                    skipToEndOfLine();
                    p = this.pos;
                    l = this.limit;
                    break;
                case 47:
                    this.pos = p2;
                    if (p2 == l) {
                        this.pos--;
                        boolean charsLoaded = fillBuffer(2);
                        this.pos++;
                        if (!charsLoaded) {
                            p = p2;
                            return c;
                        }
                    }
                    checkLenient();
                    switch (buffer[this.pos]) {
                        case '*':
                            this.pos++;
                            if (skipTo("*/")) {
                                p = this.pos + 2;
                                l = this.limit;
                                break;
                            }
                            throw syntaxError("Unterminated comment");
                        case '/':
                            this.pos++;
                            skipToEndOfLine();
                            p = this.pos;
                            l = this.limit;
                            break;
                        default:
                            p = p2;
                            return c;
                    }
                default:
                    this.pos = p2;
                    p = p2;
                    return c;
            }
        }
    }

    private void checkLenient() {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void skipToEndOfLine() {
        char c;
        do {
            if (this.pos < this.limit || fillBuffer(1)) {
                char[] cArr = this.buffer;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == '\r') {
                    return;
                }
            } else {
                return;
            }
        } while (c != '\n');
    }

    private boolean skipTo(String toFind) {
        while (true) {
            if (this.pos + toFind.length() > this.limit && !fillBuffer(toFind.length())) {
                return false;
            }
            int c = 0;
            while (c < toFind.length()) {
                if (this.buffer[this.pos + c] != toFind.charAt(c)) {
                    this.pos++;
                } else {
                    c++;
                }
            }
            return true;
        }
    }

    private String nextString(char quote) {
        char[] buffer = this.buffer;
        StringBuilder builder = null;
        do {
            int p = this.pos;
            int l = this.limit;
            int start = p;
            int p2 = p;
            while (p2 < l) {
                p = p2 + 1;
                char c = buffer[p2];
                if (c == quote) {
                    this.pos = p;
                    if (this.skipping) {
                        return "skipped!";
                    }
                    if (builder == null) {
                        return this.stringPool.get(buffer, start, (p - start) - 1);
                    }
                    builder.append(buffer, start, (p - start) - 1);
                    return builder.toString();
                }
                if (c == '\\') {
                    this.pos = p;
                    if (builder == null) {
                        builder = new StringBuilder();
                    }
                    builder.append(buffer, start, (p - start) - 1);
                    builder.append(readEscapeCharacter());
                    p = this.pos;
                    l = this.limit;
                    start = p;
                }
                p2 = p;
            }
            if (builder == null) {
                builder = new StringBuilder();
            }
            builder.append(buffer, start, p2 - start);
            this.pos = p2;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    private String nextLiteral(boolean assignOffsetsOnly) {
        StringBuilder builder = null;
        this.valuePos = -1;
        this.valueLength = 0;
        int i = 0;
        while (true) {
            String result;
            if (this.pos + i < this.limit) {
                switch (this.buffer[this.pos + i]) {
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                    case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        checkLenient();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.buffer.length) {
                if (builder == null) {
                    builder = new StringBuilder();
                }
                builder.append(this.buffer, this.pos, i);
                this.valueLength += i;
                this.pos += i;
                i = 0;
                if (fillBuffer(1)) {
                }
            } else if (!fillBuffer(i + 1)) {
                this.buffer[this.limit] = '\u0000';
            }
            if (assignOffsetsOnly && builder == null) {
                this.valuePos = this.pos;
                result = null;
            } else if (this.skipping) {
                result = "skipped!";
            } else if (builder == null) {
                result = this.stringPool.get(this.buffer, this.pos, i);
            } else {
                builder.append(this.buffer, this.pos, i);
                result = builder.toString();
            }
            this.valueLength += i;
            this.pos += i;
            return result;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + getLineNumber() + " column " + getColumnNumber();
    }

    private char readEscapeCharacter() {
        if (this.pos != this.limit || fillBuffer(1)) {
            char[] cArr = this.buffer;
            int i = this.pos;
            this.pos = i + 1;
            char escaped = cArr[i];
            switch (escaped) {
                case 'b':
                    return '\b';
                case LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
                    return '\f';
                case 'n':
                    return '\n';
                case 'r':
                    return '\r';
                case 't':
                    return '\t';
                case 'u':
                    if (this.pos + 4 <= this.limit || fillBuffer(4)) {
                        char result = '\u0000';
                        int i2 = this.pos;
                        int end = i2 + 4;
                        while (i2 < end) {
                            char c = this.buffer[i2];
                            result = (char) (result << 4);
                            if (c >= '0' && c <= '9') {
                                result = (char) ((c - 48) + result);
                            } else if (c >= 'a' && c <= 'f') {
                                result = (char) (((c - 97) + 10) + result);
                            } else if (c < 'A' || c > 'F') {
                                throw new NumberFormatException("\\u" + this.stringPool.get(this.buffer, this.pos, 4));
                            } else {
                                result = (char) (((c - 65) + 10) + result);
                            }
                            i2++;
                        }
                        this.pos += 4;
                        return result;
                    }
                    throw syntaxError("Unterminated escape sequence");
                default:
                    return escaped;
            }
        }
        throw syntaxError("Unterminated escape sequence");
    }

    private JsonToken readLiteral() {
        this.value = nextLiteral(true);
        if (this.valueLength == 0) {
            throw syntaxError("Expected literal value");
        }
        this.token = decodeLiteral();
        if (this.token == JsonToken.STRING) {
            checkLenient();
        }
        return this.token;
    }

    private JsonToken decodeLiteral() {
        if (this.valuePos == -1) {
            return JsonToken.STRING;
        }
        if (this.valueLength == 4 && (('n' == this.buffer[this.valuePos] || 'N' == this.buffer[this.valuePos]) && (('u' == this.buffer[this.valuePos + 1] || 'U' == this.buffer[this.valuePos + 1]) && (('l' == this.buffer[this.valuePos + 2] || 'L' == this.buffer[this.valuePos + 2]) && ('l' == this.buffer[this.valuePos + 3] || 'L' == this.buffer[this.valuePos + 3]))))) {
            this.value = "null";
            return JsonToken.NULL;
        } else if (this.valueLength == 4 && (('t' == this.buffer[this.valuePos] || 'T' == this.buffer[this.valuePos]) && (('r' == this.buffer[this.valuePos + 1] || 'R' == this.buffer[this.valuePos + 1]) && (('u' == this.buffer[this.valuePos + 2] || 'U' == this.buffer[this.valuePos + 2]) && ('e' == this.buffer[this.valuePos + 3] || 'E' == this.buffer[this.valuePos + 3]))))) {
            this.value = TRUE;
            return JsonToken.BOOLEAN;
        } else if (this.valueLength == 5 && (('f' == this.buffer[this.valuePos] || 'F' == this.buffer[this.valuePos]) && (('a' == this.buffer[this.valuePos + 1] || 'A' == this.buffer[this.valuePos + 1]) && (('l' == this.buffer[this.valuePos + 2] || 'L' == this.buffer[this.valuePos + 2]) && (('s' == this.buffer[this.valuePos + 3] || 'S' == this.buffer[this.valuePos + 3]) && ('e' == this.buffer[this.valuePos + 4] || 'E' == this.buffer[this.valuePos + 4])))))) {
            this.value = FALSE;
            return JsonToken.BOOLEAN;
        } else {
            this.value = this.stringPool.get(this.buffer, this.valuePos, this.valueLength);
            return decodeNumber(this.buffer, this.valuePos, this.valueLength);
        }
    }

    private JsonToken decodeNumber(char[] chars, int offset, int length) {
        int i = offset;
        int c = chars[i];
        if (c == 45) {
            i++;
            c = chars[i];
        }
        if (c == 48) {
            i++;
            c = chars[i];
        } else if (c < 49 || c > 57) {
            return JsonToken.STRING;
        } else {
            i++;
            c = chars[i];
            while (c >= 48 && c <= 57) {
                i++;
                c = chars[i];
            }
        }
        if (c == 46) {
            i++;
            c = chars[i];
            while (c >= 48 && c <= 57) {
                i++;
                c = chars[i];
            }
        }
        if (c == 101 || c == 69) {
            i++;
            c = chars[i];
            if (c == 43 || c == 45) {
                i++;
                c = chars[i];
            }
            if (c < 48 || c > 57) {
                return JsonToken.STRING;
            }
            i++;
            c = chars[i];
            while (c >= 48 && c <= 57) {
                i++;
                c = chars[i];
            }
        }
        if (i == offset + length) {
            return JsonToken.NUMBER;
        }
        return JsonToken.STRING;
    }

    private IOException syntaxError(String message) {
        throw new MalformedJsonException(message + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
}
